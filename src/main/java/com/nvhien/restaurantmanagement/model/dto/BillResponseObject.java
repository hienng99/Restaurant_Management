package com.nvhien.restaurantmanagement.model.dto;

import java.util.List;

public class BillResponseObject {
    private Long billId;
    private Double total;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setItems(List<BillItemResponseObject> items) {
        this.items = items;
    }
}
