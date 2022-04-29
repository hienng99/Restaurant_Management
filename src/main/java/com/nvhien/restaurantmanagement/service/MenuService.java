package com.nvhien.restaurantmanagement.service;

import com.nvhien.restaurantmanagement.Mapper;
import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.dto.ResponseObject;
import com.nvhien.restaurantmanagement.model.MenuItem;
import com.nvhien.restaurantmanagement.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuItemRepository repository;

    private Mapper mapper = new Mapper();

    public ResponseEntity<ResponseObject> create(MenuItem menuItem) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                mapper.toResponse(Constant.OK, "Create menu item successfully.", repository.save(menuItem))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    mapper.toResponse(Constant.FAILED, "Create menu item failed.", Constant.EMPTY_STRING)
            );
        }
    }

    public ResponseEntity<ResponseObject> list() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    mapper.toResponse(Constant.OK, "List menu item successfully.", repository.findAll())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    mapper.toResponse(Constant.FAILED, "List menu item failed.", Constant.EMPTY_STRING)
            );
        }
    }

    public ResponseEntity<ResponseObject> getOne(Long id) {
        try {
            Optional<MenuItem> result = repository.findById(id);
            if (result.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(
                        mapper.toResponse(Constant.OK, "Get item successfully.", result.get())
                );
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject(Constant.FAILED, "Menu item with ID: " + id + " does not exist.", Constant.EMPTY_STRING)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(Constant.FAILED, "Get item failed.", Constant.EMPTY_STRING)
            );
        }
    }

    public ResponseEntity<ResponseObject> update(Long id, MenuItem newMenuItem) {
        try {
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
                    mapper.toResponse(Constant.OK, "Updated menu item successfully.", updatedMenuItem)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    mapper.toResponse(Constant.FAILED, "Updated menu item failed.", Constant.EMPTY_STRING)
            );
        }
    }

    public ResponseEntity<ResponseObject> delete(Long id) {
        try {
            Boolean exists = repository.existsById(id);
            if(exists) {
                repository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject(Constant.OK, "Delete menu item successfully.", Constant.EMPTY_STRING)
                );
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject(Constant.FAILED, "Cannot find menu item to delete.", Constant.EMPTY_STRING)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(Constant.FAILED, "Delete menu item failed.", Constant.EMPTY_STRING)
            );
        }
    }
}
