package com.nvhien.restaurantmanagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "item", uniqueConstraints = {@UniqueConstraint(columnNames = "id"), @UniqueConstraint(columnNames = "name")})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, unique = true)
    private String name;

    @Column
    @Type(type = "text")
    private String description;

    @Column(unique = true)
    @Type(type = "text")
    private String image;

    private String unit;

    private double price;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "bill_item",
            joinColumns = {@JoinColumn(name = "item")},
            inverseJoinColumns = {@JoinColumn(name = "bill")}
    )
    private Set<Bill> bills = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
