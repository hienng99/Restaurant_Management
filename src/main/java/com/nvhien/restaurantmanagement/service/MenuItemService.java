package com.nvhien.restaurantmanagement.service;

import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.model.entity.MenuItem;
import com.nvhien.restaurantmanagement.model.exception.MenuItemNameAlreadyExistException;
import com.nvhien.restaurantmanagement.model.exception.MenuItemNotFoundException;
import com.nvhien.restaurantmanagement.model.mapper.ResponseBodyMapper;
import com.nvhien.restaurantmanagement.model.mapper.ResponseEntityMapper;
import com.nvhien.restaurantmanagement.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository repository;

    public List<MenuItem> listAll() {
        return repository.findAll();
    }

    public void create(MenuItem item) throws MenuItemNameAlreadyExistException {
        String itemName = item.getName();
        if (repository.existsByName(itemName)) {
            throw new MenuItemNameAlreadyExistException("The item with name=" + itemName + " is already exist.");
        }
        repository.save(item);
    }

    public void update(Long id, MenuItem newItem) throws MenuItemNotFoundException {
        if (repository.existsById(id)) {
            repository.findById(id).map(item -> {
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setImage(newItem.getImage());
                item.setPrice(newItem.getPrice());
                item.setDetail(newItem.getDetail());
                return repository.save(item);
            });
        } else {
            throw new MenuItemNotFoundException("Cannot find menu item with ID=" + id + " to update.");
        }
    }

    public MenuItem get(Long id) throws MenuItemNotFoundException {
        Optional<MenuItem> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new MenuItemNotFoundException("The menu item with ID=" + id + " does not exist.");
    }

    public void delete(Long id) throws MenuItemNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new MenuItemNotFoundException("Cannot find menu item with ID=" + id + " to delete.");
        }
    }
}
