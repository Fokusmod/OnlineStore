package com.example.backonlinestore.controller;


import com.example.backonlinestore.Dto.CategoryDto;
import com.example.backonlinestore.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryDto> findAll (){
       return categoryService.findAll().stream().map(CategoryDto::new).collect(Collectors.toList());
    }
}
