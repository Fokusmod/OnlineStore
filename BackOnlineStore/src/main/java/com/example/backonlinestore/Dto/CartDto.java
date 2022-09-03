package com.example.backonlinestore.Dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CartDto {

    private String username;
    private Long productId;

}
