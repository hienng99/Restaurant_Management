package com.nvhien.restaurantmanagement.model.entity;

import javax.persistence.*;

@Entity(name = "BillItem")
@Table(name = "bill_item")
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billItemId;

    @ManyToOne
    private Bill bill;

    @ManyToOne
    private MenuItem menuItem;

    @Column(nullable = false)
    private Double quantity;

    @Column
    private Long orderedTime;

    @Override
    public String toString() {
        return "BillItem{" +
                "billItemId=" + billItemId +
                ", bill=" + bill +
                ", menuItem=" + menuItem +
                ", quantity=" + quantity +
                ", orderedTime=" + orderedTime +
                '}';
    }

    public Long getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(Long billItemId) {
        this.billItemId = billItemId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
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
