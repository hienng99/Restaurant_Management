package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.model.MenuItem;
import com.nvhien.restaurantmanagement.model.ResponseObject;
import com.nvhien.restaurantmanagement.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuItemService service;

    //Get all menu item
    @GetMapping("/api/menu")
    List<MenuItem> getAllMenuItem() {
        return service.listAll();
    }

    //Create new menu item with POST method
    @PostMapping("/api/menu/create")
    ResponseEntity<ResponseObject> createMenuItem(@RequestBody MenuItem newMenuItem) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create menu item successfully", service.save(newMenuItem))
        );
    }
}
