package com.nvhien.restaurantmanagement.model.dto;

import lombok.Data;

@Data
public class ItemDto {
    private long id;
    private String name;
    private String description;
    private String image;
    private String unit;
    private double price;
}
