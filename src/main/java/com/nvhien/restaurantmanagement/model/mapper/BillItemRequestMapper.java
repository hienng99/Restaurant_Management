package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.BillItemRequestObject;
import com.nvhien.restaurantmanagement.model.entity.Bill;
import com.nvhien.restaurantmanagement.model.entity.BillItem;
import com.nvhien.restaurantmanagement.model.entity.MenuItem;

public class BillItemRequestMapper {
    /*
    Convert data of bill and bill item request and bill to bill item
     */
    public static BillItem toBillItem(Bill bill, MenuItem menuItem, BillItemRequestObject billItemRequest) {
        BillItem response = new BillItem();
        response.setBill(bill);
        response.setMenuItem(menuItem);
        response.setQuantity(billItemRequest.getQuantity());
        response.setOrderedTime(billItemRequest.getOrderedTime());
        return response;
    }
}
