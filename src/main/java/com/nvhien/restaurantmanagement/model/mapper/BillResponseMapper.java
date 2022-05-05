package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.BillItemResponseObject;
import com.nvhien.restaurantmanagement.model.dto.BillResponseObject;
import com.nvhien.restaurantmanagement.model.entity.Bill;

import java.util.List;

public class BillResponseMapper {
    public static BillResponseObject fromBillAndBillItemResponse(Bill bill, List<BillItemResponseObject> billItemResponseList) {
        BillResponseObject response = new BillResponseObject();
        response.setBillId(bill.getId());
        response.setTotal(bill.getTotal());
        response.setItems(billItemResponseList);
        return response;
    }
}
