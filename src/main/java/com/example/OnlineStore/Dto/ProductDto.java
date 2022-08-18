package com.example.OnlineStore.Dto;

import com.example.OnlineStore.Models.Category;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ProductDto {

    private Long id;

    private String title;

    private Double price;

    private String categoryTitle;
}
