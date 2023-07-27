package com.nvhien.restaurantmanagement.service.itf;

import com.nvhien.restaurantmanagement.model.entity.Item;
import com.nvhien.restaurantmanagement.model.exception.ItemAlreadyExistException;
import com.nvhien.restaurantmanagement.model.exception.ItemNotFoundException;

import java.util.List;

public interface ItemService {
    List<Item> getAll();

    Item get(long id) throws ItemNotFoundException;

    Item create(Item item) throws ItemAlreadyExistException;
}
