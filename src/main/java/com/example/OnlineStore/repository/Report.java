package com.example.OnlineStore.repository;

import com.example.OnlineStore.Models.Statistic;
import org.springframework.data.repository.CrudRepository;

public interface Report extends CrudRepository<Statistic,Long> {
}
