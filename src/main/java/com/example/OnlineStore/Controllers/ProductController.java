package com.example.OnlineStore.Controllers;

import com.example.OnlineStore.Dto.ProductDto;
import com.example.OnlineStore.Dto.ProductMapstructMapper;
import com.example.OnlineStore.Models.Product;
import com.example.OnlineStore.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    private final ProductMapstructMapper productMapstructMapper;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        List<ProductDto> list = productService.getProducts()
                .stream()
                .map(productMapstructMapper::mapToDto)
                .collect(Collectors.toList());
        System.out.println(list);
        return list;
    }

    @PostMapping("/product/{id}")
    public void addCart(@PathVariable Long id) {
        ProductDto product = productMapstructMapper.mapToDto(productService.findById(id).get());
        System.out.println(product.getTitle());
    }

}
