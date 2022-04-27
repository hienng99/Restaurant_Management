package com.nvhien.restaurantmanagement.service;

import com.nvhien.restaurantmanagement.model.MenuItem;
import com.nvhien.restaurantmanagement.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired private MenuItemRepository repository;

    public List<MenuItem> listAll() {
        return (List<MenuItem>) repository.findAll();
    }

    public Object save(MenuItem menuItem) {
        return repository.save(menuItem);
    }
}
