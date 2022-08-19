package com.example.OnlineStore.Dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CartDto {

    private String username;
    private Long productId;

}
