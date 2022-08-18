package com.example.OnlineStore.Service;

import com.example.OnlineStore.Dto.ProductDto;
import com.example.OnlineStore.Models.Product;
import com.example.OnlineStore.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

//    public Product create(ProductDto dto) {
//        return productRepository.save(productMapper.mapToEntity(dto));
//    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
