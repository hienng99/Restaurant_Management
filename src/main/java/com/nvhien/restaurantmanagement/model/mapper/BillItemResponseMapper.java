package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.BillItemResponseObject;
import com.nvhien.restaurantmanagement.model.entity.BillItem;
import com.nvhien.restaurantmanagement.model.entity.MenuItem;

public class BillItemResponseMapper {
    public static BillItemResponseObject fromMenuItemAndBillItem(MenuItem menuItem, BillItem billItem) {
        BillItemResponseObject response = new BillItemResponseObject();
        response.setId(billItem.getBillItemId());
        response.setMenuItemId(menuItem.getId());
        response.setMenuItemName(menuItem.getName());
        response.setMenuItemPrice(menuItem.getPrice());
        response.setQuantity(billItem.getQuantity());
        response.setOrderedTime(billItem.getOrderedTime());
        return response;
    }
}
