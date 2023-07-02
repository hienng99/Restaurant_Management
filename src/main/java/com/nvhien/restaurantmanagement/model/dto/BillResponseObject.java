package com.nvhien.restaurantmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BillResponseObject {
    private Long billId;
    private Double total;
    private List<BillItemResponseObject> items;
}
