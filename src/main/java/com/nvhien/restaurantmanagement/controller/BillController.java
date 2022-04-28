package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.model.*;
import com.nvhien.restaurantmanagement.repositories.BillItemRepository;
import com.nvhien.restaurantmanagement.repositories.BillRepository;
import com.nvhien.restaurantmanagement.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/bill")
public class BillController {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private BillItemRepository billItemRepository;

    @Autowired
    private BillRepository billRepository;

    /*
    List bill
     */
    @GetMapping("")
    ResponseEntity<ResponseObject> listBill() {
        List<BillResponseObject> responseData = new ArrayList<>();
        List<Long> billIdList = billRepository.listId();
        for (Long billId : billIdList) {
            List<BillItem> billItemList = billItemRepository.findAllByBillId(billId);
            List<BillItemResponseObject> billItemResponseObjectList = new ArrayList<>();
            for (BillItem billItem : billItemList) {
                Long menuItemId = billItem.getMenuItemId();
                MenuItem menuItem = menuItemRepository.findById(menuItemId).get();
                BillItemResponseObject billItemResponseObject = new BillItemResponseObject();
                billItemResponseObject.setMenuItemId(menuItemId);
                billItemResponseObject.setMenuItemName(menuItem.getName());
                billItemResponseObject.setMenuItemPrice(menuItem.getPrice());
                billItemResponseObject.setQuantity(billItem.getQuantity());
                billItemResponseObject.setOrderedTime(billItem.getOrderedTime());
                billItemResponseObjectList.add(billItemResponseObject);
            }
            BillResponseObject billResponseObject = new BillResponseObject();
            billResponseObject.setBillId(billId);
            billResponseObject.setItems(billItemResponseObjectList);
            responseData.add(billResponseObject);
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(Constant.RESPONSE_STATUS_OK, "List bill successfully.", responseData)
        );
    }

    //Create bill with at least 1 item
    @PostMapping("/create")
    ResponseEntity<ResponseObject> createBill(@RequestBody BillItemRequestObject billItemRequestObject) {
        try {
            Bill initialBill = billRepository.save(new Bill());
            BillItem billItem = new BillItem();
            billItem.setBillId(initialBill.getId());
            billItem.setMenuItemId(billItemRequestObject.getMenuItemId());
            billItem.setQuantity(billItemRequestObject.getQuantity());
            billItem.setOrderedTime(billItemRequestObject.getOrderedTime());
            billItemRepository.save(billItem);
            Bill finalBill = billRepository.findById(initialBill.getId()).get();
            Double total = menuItemRepository.findById(billItemRequestObject.getMenuItemId()).get().getPrice() * billItemRequestObject.getQuantity();
            finalBill.setTotal(total);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_OK, "Create bill successfully.", billRepository.save(finalBill))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_FAILED, "Cannot create bill.", Constant.EMPTY_STRING)
            );
        }
    }

    //Add an item into bill
    @PostMapping("/add/{billId}")
    ResponseEntity<ResponseObject> addItem(@PathVariable Long billId, @RequestBody BillItemRequestObject billItemRequestObject) {
        try {
            BillItem newBillItem = new BillItem();
            newBillItem.setBillId(billId);
            newBillItem.setMenuItemId(billItemRequestObject.getMenuItemId());
            newBillItem.setQuantity(billItemRequestObject.getQuantity());
            newBillItem.setOrderedTime(billItemRequestObject.getOrderedTime());
            Bill updatedBill = billRepository.findById(billId).get();
            Double newTotal = updatedBill.getTotal() + menuItemRepository.findById(billItemRequestObject.getMenuItemId()).get().getPrice() * billItemRequestObject.getQuantity();
            updatedBill.setTotal(newTotal);
            billRepository.save(updatedBill);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_OK, "Add item into bill successfully.", billItemRepository.save(newBillItem))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_FAILED, "Cannot add the item into bill.", Constant.EMPTY_STRING)
            );
        }
    }

    //Remove an item from bill
    @DeleteMapping("/{billId}/{itemId}")
    ResponseEntity<ResponseObject> removeItem(@PathVariable("billId") Long billId, @PathVariable("itemId") Long itemId) {
        try {
            BillItem deletedItem = billItemRepository.findById(itemId).get();
            Bill updatedBill = billRepository.findById(billId).get();
            Double newTotal = updatedBill.getTotal() - menuItemRepository.findById(deletedItem.getMenuItemId()).get().getPrice() * deletedItem.getQuantity();
            updatedBill.setTotal(newTotal);
            billItemRepository.deleteById(itemId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_OK, "Delete item successfully.", billRepository.save(updatedBill))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(Constant.RESPONSE_STATUS_FAILED, "Cannot remove the item from bill.", Constant.EMPTY_STRING)
            );
        }
    }
}
