package com.example.backonlinestore.repository;


import com.example.backonlinestore.Models.Statistic;
import org.springframework.data.repository.CrudRepository;

public interface Report extends CrudRepository<Statistic,Long> {
}
