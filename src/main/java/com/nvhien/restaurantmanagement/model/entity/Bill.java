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
public class Bill {
    @Id
    private Long id;

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private double total;
}
