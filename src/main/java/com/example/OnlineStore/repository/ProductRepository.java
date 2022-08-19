package com.example.OnlineStore.repository;


import com.example.OnlineStore.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.price <= :price")
    List<Product> findMin (int price);

    @Query("select p from Product p where p.price >= :price")
    List<Product> findMax (int price);

    List<Product> findByPriceBetween (int min, int max);

    Optional<Product> findByTitle(String title);
}
