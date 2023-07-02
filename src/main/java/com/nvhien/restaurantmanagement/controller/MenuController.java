package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.common.ResponseCode;
import com.nvhien.restaurantmanagement.model.entity.Item;
import com.nvhien.restaurantmanagement.model.exception.ItemNameAlreadyExistException;
import com.nvhien.restaurantmanagement.model.exception.ItemNotFoundException;
import com.nvhien.restaurantmanagement.model.mapper.ResponseBodyMapper;
import com.nvhien.restaurantmanagement.model.mapper.ResponseEntityMapper;
import com.nvhien.restaurantmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/menu")
public class MenuController {
    @Autowired
    private ItemService service;

    @GetMapping("/")
    public ResponseEntity listAllItems() {
        return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create(ResponseCode.SUCCESS, "List menu items successfully.", service.listAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneItem(@PathVariable Long id) {
        try {
            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create(ResponseCode.SUCCESS, "Get menu item successfully.", service.get(id)));
        } catch (ItemNotFoundException e) {
            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(ResponseCode.ITEM_NOT_FOUND, e.getMessage(), Constant.EMPTY_STRING));
        }
    }

    @PostMapping("/")
    public ResponseEntity createNewItem(@RequestBody Item item) {
        try {
            service.create(item);
            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create(0, "Create menu item successfully.", Constant.EMPTY_STRING));
        } catch (ItemNameAlreadyExistException e) {
            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(400, e.getMessage(), Constant.EMPTY_STRING));
        }
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody Item item) {
//        try {
//            service.update(id, item);
//            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Update menu item successfully.", Constant.EMPTY_STRING));
//        } catch (ItemNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        }
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity deleteItem(@PathVariable Long id) {
//        try {
//            service.delete(id);
//            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Delete menu item successfully.", Constant.EMPTY_STRING));
//        } catch (ItemNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        }
//    }
}
