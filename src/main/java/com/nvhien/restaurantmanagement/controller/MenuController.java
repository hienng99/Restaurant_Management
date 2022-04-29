package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.model.MenuItem;
import com.nvhien.restaurantmanagement.dto.ResponseObject;
import com.nvhien.restaurantmanagement.repository.MenuItemRepository;
import com.nvhien.restaurantmanagement.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/menu")
public class MenuController {
    @Autowired
    private MenuService service;

    @GetMapping("")
    ResponseEntity<ResponseObject> listMenuItem() {
        return service.list();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getOneMenuItem(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("/")
    ResponseEntity<ResponseObject> createMenuItem(@RequestBody MenuItem newMenuItem) {
        return service.create(newMenuItem);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem newMenuItem) {
        return service.update(id, newMenuItem);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteMenuItem(@PathVariable Long id) {
        return service.delete(id);
    }
}
