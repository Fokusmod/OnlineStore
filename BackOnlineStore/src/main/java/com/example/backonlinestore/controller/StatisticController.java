package com.example.backonlinestore.controller;


import com.example.backonlinestore.Models.Statistic;
import com.example.backonlinestore.Service.StatisticService;
import lombok.RequiredArgsConstructor;
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
