package com.nvhien.restaurantmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BillItemRequestObject {
    private Long itemId;
    private Double quantity;
    private Timestamp orderedTime;
}
