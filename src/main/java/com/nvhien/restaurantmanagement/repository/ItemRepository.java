package com.nvhien.restaurantmanagement.repository;

import com.nvhien.restaurantmanagement.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Boolean existsByName(String name);
}
