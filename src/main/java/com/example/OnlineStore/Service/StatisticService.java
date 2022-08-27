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


    private Map<String, Map<String, List<Long>>> stats = new HashMap<>(0,1);
    private final Report report;



}

