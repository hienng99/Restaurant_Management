package com.nvhien.restaurantmanagement.model;

import java.util.List;

public class BillResponseObject {
    private Long billId;
    private List<BillItemResponseObject> items;

    public BillResponseObject() {
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public List<BillItemResponseObject> getItems() {
        return items;
    }

    public void setItems(List<BillItemResponseObject> items) {
        this.items = items;
    }
}
