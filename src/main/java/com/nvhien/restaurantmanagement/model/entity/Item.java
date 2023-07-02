package com.nvhien.restaurantmanagement.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    @Id
    private long id;

    private String name;
    private String description;
    private String image;
    private String unit;
    private double price;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
