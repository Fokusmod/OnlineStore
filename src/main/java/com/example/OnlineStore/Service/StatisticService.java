package com.example.OnlineStore.Service;


import com.example.OnlineStore.Models.Statistic;
import com.example.OnlineStore.repository.Report;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@Data
@RequiredArgsConstructor
public class StatisticService {


    private Long id = ReportType.EXECUTION_TIME.getId();
    private Map<String, Map<String, List<Long>>> stats = new HashMap<>();
    private final Report report;

}

