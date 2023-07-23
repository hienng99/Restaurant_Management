package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.common.ResponseCode;
import com.nvhien.restaurantmanagement.model.dto.ItemDto;
import com.nvhien.restaurantmanagement.model.dto.Response;
import com.nvhien.restaurantmanagement.model.exception.ItemNotFoundException;
import com.nvhien.restaurantmanagement.model.mapper.ResponseEntityMapper;
import com.nvhien.restaurantmanagement.service.impl.ItemServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/menu")
public class ItemController {
    @Autowired
    private ItemServiceImpl service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/")
    public ResponseEntity listAllItems() {

        return ResponseEntityMapper.success(new Response(ResponseCode.SUCCESS,
                "List menu items successfully.",
                service.getAll()
                        .stream()
                        .map(item -> mapper.map(item, ItemDto.class))
                        .collect(Collectors.toList())
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneItem(@PathVariable Long id) {
        try {
            return ResponseEntityMapper.success(new Response(ResponseCode.SUCCESS,
                    "Get menu item successfully.",
                    mapper.map(service.get(id), ItemDto.class)
            ));
        } catch (ItemNotFoundException e) {
            return ResponseEntityMapper.notFound(Response.builder()
                    .code(ResponseCode.ITEM_NOT_FOUND)
                    .message(e.getMessage())
                    .build()
            );
        }
    }
//
//    @PostMapping("/")
//    public ResponseEntity createNewItem(@RequestBody Item item) {
//        try {
//            service.create(item);
//            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create(0, "Create menu item successfully.", Constant.EMPTY_STRING));
//        } catch (ItemNameAlreadyExistException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(400, e.getMessage(), Constant.EMPTY_STRING));
//        }
//    }
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
