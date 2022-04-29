package com.nvhien.restaurantmanagement;

import com.nvhien.restaurantmanagement.dto.BillItemRequestObject;
import com.nvhien.restaurantmanagement.dto.BillItemResponseObject;
import com.nvhien.restaurantmanagement.dto.BillResponseObject;
import com.nvhien.restaurantmanagement.dto.ResponseObject;
import com.nvhien.restaurantmanagement.model.Bill;
import com.nvhien.restaurantmanagement.model.BillItem;
import com.nvhien.restaurantmanagement.model.MenuItem;

import java.util.List;

public class Mapper {
    public Mapper() {
    }

    /*
    Convert entity to response data
     */
    public <T> ResponseObject toResponse(String status, String message, T object) {
        return new ResponseObject(status, message, object);
    }

    /*
    Convert data of menu item and bill item to bill item response
     */
    public BillItemResponseObject toBillItemResponse(MenuItem menuItem, BillItem billItem) {
        BillItemResponseObject response = new BillItemResponseObject();
        response.setMenuItemId(menuItem.getId());
        response.setMenuItemName(menuItem.getName());
        response.setMenuItemPrice(menuItem.getPrice());
        response.setQuantity(billItem.getQuantity());
        response.setOrderedTime(billItem.getOrderedTime());
        return response;
    }

    /*
    Convert list of bill item response to bill response
     */
    public BillResponseObject toBillResponse(Bill bill, List<BillItemResponseObject> billItemResponseList) {
        BillResponseObject response = new BillResponseObject();
        response.setBillId(bill.getId());
        response.setTotal(bill.getTotal());
        response.setItems(billItemResponseList);
        return response;
    }

    /*
    Convert data of bill item request and bill to bill item
     */
    public BillItem toBillItem(Bill bill, BillItemRequestObject billItemRequest) {
        BillItem response = new BillItem();
        response.setBillId(bill.getId());
        response.setMenuItemId(billItemRequest.getMenuItemId());
        response.setQuantity(billItemRequest.getQuantity());
        response.setOrderedTime(billItemRequest.getOrderedTime());
        return response;
    }
}
