package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.BillItemResponseObject;
import com.nvhien.restaurantmanagement.model.entity.BillItem;
import com.nvhien.restaurantmanagement.model.entity.Item;

public class BillItemResponseMapper {
    public static BillItemResponseObject fromMenuItemAndBillItem(Item menuItem, BillItem billItem) {
        BillItemResponseObject response = new BillItemResponseObject();
        response.setId(billItem.getItem().getId());
        response.setItemId(menuItem.getId());
        response.setItemName(menuItem.getName());
        response.setItemPrice(menuItem.getPrice());
        response.setQuantity(billItem.getQuantity());
        return response;
    }
}
