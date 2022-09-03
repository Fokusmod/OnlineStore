package com.example.backonlinestore.repository;



import com.example.backonlinestore.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p order by p.id asc")
    List<Product> findAll();

    @Query("select p from Product p where p.price <= :price")
    List<Product> findMin (int price);

    @Query("select p from Product p where p.price >= :price")
    List<Product> findMax (int price);

    List<Product> findByPriceBetween (int min, int max);

    Optional<Product> findByTitle(String title);


}
