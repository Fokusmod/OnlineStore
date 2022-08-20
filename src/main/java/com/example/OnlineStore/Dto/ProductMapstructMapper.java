package com.example.OnlineStore.Dto;

import com.example.OnlineStore.Models.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapstructMapper {


    @Mappings(value = {@Mapping(target = "categoryTitle", source ="category.title")})
    ProductDto mapToDto(Product product);
}
