package com.example.backonlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BackOnlineStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackOnlineStoreApplication.class, args);
    }

}
