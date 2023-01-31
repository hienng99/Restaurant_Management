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
public class BillItem {
    @Id
    private Long id;

    @ManyToOne
    private Bill bill;

    @ManyToOne
    private Item item;

    private double quantity;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
