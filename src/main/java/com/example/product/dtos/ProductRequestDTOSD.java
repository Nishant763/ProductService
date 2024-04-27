package com.example.product.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTOSD {
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;
    private String email;
}
