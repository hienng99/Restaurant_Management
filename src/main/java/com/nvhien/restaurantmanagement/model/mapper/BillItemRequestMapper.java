package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.BillItemRequestObject;
import com.nvhien.restaurantmanagement.model.entity.Bill;
import com.nvhien.restaurantmanagement.model.entity.BillItem;
import com.nvhien.restaurantmanagement.model.entity.Item;

public class BillItemRequestMapper {
    /*
    Convert data of bill and bill item request and bill to bill item
     */
    public static BillItem toBillItem(Bill bill, Item menuItem, BillItemRequestObject billItemRequest) {
        BillItem response = new BillItem();
        response.setBill(bill);
        response.setItem(menuItem);
        response.setQuantity(billItemRequest.getQuantity());
        response.setUpdatedAt(billItemRequest.getOrderedTime());
        return response;
    }
}
