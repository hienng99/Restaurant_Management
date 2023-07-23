package com.nvhien.restaurantmanagement.service.impl;

import com.nvhien.restaurantmanagement.model.entity.Item;
import com.nvhien.restaurantmanagement.model.exception.ItemNotFoundException;
import com.nvhien.restaurantmanagement.repository.ItemRepository;
import com.nvhien.restaurantmanagement.service.itf.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }

    @Override
    public Item get(long id) throws ItemNotFoundException {
        if (repository.existsById(id)) {
            return repository.getById(id);
        } else {
            throw new ItemNotFoundException("Item does not exist.");
        }
    }
}
