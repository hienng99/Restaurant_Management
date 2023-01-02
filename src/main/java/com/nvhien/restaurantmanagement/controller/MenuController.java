package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.model.entity.MenuItem;
import com.nvhien.restaurantmanagement.model.exception.MenuItemNameAlreadyExistException;
import com.nvhien.restaurantmanagement.model.exception.MenuItemNotFoundException;
import com.nvhien.restaurantmanagement.model.mapper.ResponseBodyMapper;
import com.nvhien.restaurantmanagement.model.mapper.ResponseEntityMapper;
import com.nvhien.restaurantmanagement.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/menu")
public class MenuController {
    @Autowired
    private MenuItemService service;

    @GetMapping("/")
    public ResponseEntity listAllItems() {
        return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("List menu items successfully.", service.listAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneItem(@PathVariable Long id) {
        try {
            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Get menu item successfully.", service.get(id)));
        } catch (MenuItemNotFoundException e) {
            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
        }
    }

    @PostMapping("/")
    public ResponseEntity createNewItem(@RequestBody MenuItem item) {
        try {
            service.create(item);
            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Create menu item successfully.", Constant.EMPTY_STRING));
        } catch (MenuItemNameAlreadyExistException e) {
            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody MenuItem item) {
        try {
            service.update(id, item);
            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Update menu item successfully.", Constant.EMPTY_STRING));
        } catch (MenuItemNotFoundException e) {
            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Delete menu item successfully.", Constant.EMPTY_STRING));
        } catch (MenuItemNotFoundException e) {
            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
        }
    }
}
