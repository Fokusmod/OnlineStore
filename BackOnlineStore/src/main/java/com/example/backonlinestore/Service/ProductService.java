package com.example.backonlinestore.Service;

import com.example.backonlinestore.Dto.ProductDto;
import com.example.backonlinestore.Models.Category;
import com.example.backonlinestore.Models.Product;
import com.example.backonlinestore.aspect.ExecutionTime;
import com.example.backonlinestore.exception.ResourceNotFoundException;
import com.example.backonlinestore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryService categoryService;
    @ExecutionTime
    public List<Product> findAll() {
        return repository.findAll();
    }
    @ExecutionTime
    public Page<Product> findCatalog(int pageIndex, int pageSize) {
        return repository.findAll(PageRequest.of(pageIndex, pageSize, Sort.by("id")));
    }
    @ExecutionTime
    public Optional<Product> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @ExecutionTime
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
    @ExecutionTime
    @Transactional
    public void saveProductFromDto(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category title = " + productDto.getCategoryTitle() + " not found"));
        product.setCategory(category);
        repository.save(product);
    }
    @ExecutionTime
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Product> findMin(int price) {
        return repository.findMin(price);
    }

    public List<Product> findMax(int price) {
        return repository.findMax(price);
    }

    public List<Product> betweenPrice(int min, int max) {
        return repository.findByPriceBetween(min, max);
    }
    @ExecutionTime
    @Transactional
    public void updateProductFromDto(ProductDto change_product) {
        Product product = findById(change_product.getId())
                .orElseThrow(() -> new ResourceNotFoundException("This product = " + change_product.getTitle() + " not found"));
        product.setPrice(change_product.getPrice());
        product.setTitle(change_product.getTitle());
        Category category = categoryService.findByTitle(change_product.getCategoryTitle())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category title = " + change_product.getCategoryTitle() + " not found"));
        product.setCategory(category);
    }
}
