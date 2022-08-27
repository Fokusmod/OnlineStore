package com.example.OnlineStore.aspect;


import com.example.OnlineStore.Service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Aspect
@Component
@RequiredArgsConstructor
public class ServiceExecutionTimeAspect {

    private final StatisticService statisticService;




    @SneakyThrows
    @Around("@annotation(com.example.OnlineStore.aspect.ExecutionTime)")
    public Object setTime(ProceedingJoinPoint proceedingJoinPoint) {

        String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();

        MethodSignature ms = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = ms.getMethod();


        long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        Long result = System.currentTimeMillis() - start;

        Map<String, Map<String, List<Long>>> stats = statisticService.getStats();

        if (!stats.containsKey(className)) {
        stats.put(className, new HashMap<>());
        stats.get(className).put(method.getName(), new LinkedList<>());
        stats.get(className).get(method.getName()).add(result);
    } else {
        if (!stats.get(className).containsKey(method.getName())) {
            stats.get(className).put(method.getName(), new LinkedList<>());
        }
        if (stats.get(className).get(method.getName()).size() == 10) {
            stats.get(className).get(method.getName()).remove(0);
            stats.get(className).get(method.getName()).add(0, result);
        } else {
            stats.get(className).get(method.getName()).add(result);
        }
        statisticService.setStats(stats);
    }
        return object;
    }


}
