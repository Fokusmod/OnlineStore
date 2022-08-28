package com.example.frontonlinestore.controllerFront;

import com.example.frontonlinestore.DtoFront.CategoryDto;
import com.example.frontonlinestore.DtoFront.ProductDto;
import com.example.frontonlinestore.ServiceFront.ProductFrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductFrontController {

    private final ProductFrontService productFrontService;


    @GetMapping("/products")
    public List<ProductDto> findAll() {
        return productFrontService.getProductsFromBack();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productFrontService.deleteProductFromBack(id);
    }

    @GetMapping("/products/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productFrontService.getOneProduct(id);
    }

    @GetMapping("/category")
    public List<CategoryDto> findAllCategory() {
        return productFrontService.getAllCategory();
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody ProductDto productDto) {
        productFrontService.update(productDto);
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody ProductDto productDto) {
        productFrontService.createProduct(productDto);

    }
}
