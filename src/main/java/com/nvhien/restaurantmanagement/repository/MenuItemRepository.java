package com.nvhien.restaurantmanagement.repository;

import com.nvhien.restaurantmanagement.model.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    Boolean existsByName(String name);
}
