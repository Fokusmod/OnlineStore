package com.example.backonlinestore.Service;


import com.example.backonlinestore.repository.Report;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
@RequiredArgsConstructor
public class StatisticService {


    private Map<String, Map<String, List<Long>>> stats = new HashMap<>(0,1);
    private final Report report;



}

