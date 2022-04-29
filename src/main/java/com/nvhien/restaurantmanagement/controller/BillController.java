package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.dto.BillItemRequestObject;
import com.nvhien.restaurantmanagement.dto.ResponseObject;
import com.nvhien.restaurantmanagement.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/bill")
public class BillController {
    @Autowired
    private BillService service;

    @GetMapping("")
    ResponseEntity<ResponseObject> listBill() {
        return service.list();
    }

    @PostMapping("/")
    ResponseEntity<ResponseObject> createBill(@RequestBody BillItemRequestObject billItemRequestObject) {
        return service.create(billItemRequestObject);
    }

    @PostMapping("/{billId}")
    ResponseEntity<ResponseObject> addItem(@PathVariable Long billId, @RequestBody BillItemRequestObject billItemRequestObject) {
        return service.addItem(billId, billItemRequestObject);
    }

    @DeleteMapping("/{billId}/{itemId}")
    ResponseEntity<ResponseObject> removeItem(@PathVariable("billId") Long billId, @PathVariable("itemId") Long itemId) {
        return service.deleteItem(billId, itemId);
    }
}
