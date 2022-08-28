package com.example.frontonlinestore.ServiceFront;

import com.example.frontonlinestore.DtoFront.CategoryDto;
import com.example.frontonlinestore.DtoFront.ProductDto;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductFrontService {

    private String baseUrl = "http://localhost:8181/market/api/v1/products";


    public List<ProductDto> getProductsFromBack() {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/all";
        return restTemplate.getForObject(url, List.class, ProductDto.class);
    }

    public void deleteProductFromBack(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/" + id;
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        restTemplate.delete(url, params);
    }

    public ProductDto getOneProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = baseUrl + "/" + id;
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(url, ProductDto.class);
    }

    public List<CategoryDto> getAllCategory() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8181/market/api/v1/category";
        return restTemplate.getForObject(url, List.class, CategoryDto.class);
    }

    public void update(ProductDto productDto){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(baseUrl,productDto);
    }

    public void createProduct(ProductDto productDto) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(baseUrl,productDto,ProductDto.class);
    }

}
