package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.model.MenuItem;
import com.nvhien.restaurantmanagement.model.ResponseObject;
import com.nvhien.restaurantmanagement.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/menu")
public class MenuController {
    @Autowired
    private MenuItemRepository repository;

    //List menu item
    @GetMapping("")
    ResponseEntity<ResponseObject> listMenuItem() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(Constant.RESPONSE_STATUS_OK, "List menu item successfully.", repository.findAll())
        );
    }

    //Get a menu item
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getOneMenuItem(@PathVariable Long id) {
        Optional<MenuItem> result = repository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_OK, "Item exist", result)
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(Constant.RESPONSE_STATUS_FAILED, "Menu item with ID: " + id + " does not exist.", "")
        );
    }

    //Create new menu item
    @PostMapping("/create")
    ResponseEntity<ResponseObject> createMenuItem(@RequestBody MenuItem newMenuItem) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(Constant.RESPONSE_STATUS_OK, "Create menu item successfully", repository.save(newMenuItem))
        );
    }

    //Upsert - if menu item exist, then update; else insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem newMenuItem) {
        MenuItem updatedMenuItem = repository.findById(id)
                .map(menuItem -> {
                    menuItem.setName(newMenuItem.getName());
                    menuItem.setDescription(newMenuItem.getDescription());
                    menuItem.setImage(newMenuItem.getImage());
                    menuItem.setPrice(newMenuItem.getPrice());
                    menuItem.setDetail(newMenuItem.getDetail());
                    return repository.save(menuItem);
                }).orElseGet(() -> {
                    newMenuItem.setId(id);
                    return repository.save(newMenuItem);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(Constant.RESPONSE_STATUS_OK, "Updated menu item successfully", updatedMenuItem)
        );
    }

    //Delete menu item
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteMenuItem(@PathVariable Long id) {
        Boolean exists = repository.existsById(id);
        if(exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_OK, "Delete menu item successfully.", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(Constant.RESPONSE_STATUS_FAILED, "Cannot find menu item to delete.", "")
        );
    }
}
