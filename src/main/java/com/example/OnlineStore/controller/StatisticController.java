package com.example.OnlineStore.controller;


import com.example.OnlineStore.Models.Statistic;
import com.example.OnlineStore.Service.StatisticService;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/serviceStats")
    public Statistic getStatistic() {
        Statistic statistic = new Statistic(1L, statisticService.getStats());
        return statistic;
    }
}
