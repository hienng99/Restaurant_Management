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
public class Category {
    @Id
    private Long id;

    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
