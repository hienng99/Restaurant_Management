package com.nvhien.restaurantmanagement.model.dto;

public class BillItemRequestObject {
    private Long menuItemId;
    private Double quantity;
    private Long orderedTime;

    public BillItemRequestObject(Long menuItemId, Double quantity, Long orderedTime) {
        this.menuItemId = menuItemId;
        this.quantity = quantity;
        this.orderedTime = orderedTime;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Long orderedTime) {
        this.orderedTime = orderedTime;
    }
}
