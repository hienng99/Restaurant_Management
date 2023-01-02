package com.nvhien.restaurantmanagement.model.dto;

public class BillItemResponseObject {
    private Long id;
    private Long menuItemId;
    private String menuItemName;
    private Double menuItemPrice;
    private Double quantity;
    private Long orderedTime;

    public BillItemResponseObject() {
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public Double getMenuItemPrice() {
        return menuItemPrice;
    }

    public void setMenuItemPrice(Double menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
