package com.nvhien.restaurantmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "billItem")
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billItemId;

    @Column(nullable = false)
    private Long billId;

    @Column(nullable = false)
    private Long menuItemId;

    @Column(nullable = false)
    private Double quantity;

    private Long orderedTime;

    @Override
    public String toString() {
        return "BillItem{" +
                "billItemId=" + getBillItemId() +
                ", billId=" + getBillId() +
                ", menuItemId=" + getMenuItemId() +
                ", quantity=" + getQuantity() +
                ", orderedTime=" + getOrderedTime() +
                '}';
    }

    public Long getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Long billItemId) {
        this.billItemId = billItemId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
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
