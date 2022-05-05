package com.nvhien.restaurantmanagement.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Bill")
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "bill",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private Set<BillItem> items = new HashSet<>();

    @Column
    private Double total;

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", items=" + getItems() +
                ", total=" + total +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<BillItem> getItems() {
        return items;
    }

    public void setItems(Set<BillItem> items) {
        this.items = items;
    }
}
