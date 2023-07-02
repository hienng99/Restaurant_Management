package com.nvhien.restaurantmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BillItemResponseObject {
    private Long id;
    private Long itemId;
    private String itemName;
    private Double itemPrice;
    private Double quantity;
    private Long orderedTime;
}
