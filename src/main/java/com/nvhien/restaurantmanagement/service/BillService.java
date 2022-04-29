package com.nvhien.restaurantmanagement.service;

import com.nvhien.restaurantmanagement.Mapper;
import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.dto.BillItemRequestObject;
import com.nvhien.restaurantmanagement.dto.BillItemResponseObject;
import com.nvhien.restaurantmanagement.dto.BillResponseObject;
import com.nvhien.restaurantmanagement.dto.ResponseObject;
import com.nvhien.restaurantmanagement.model.Bill;
import com.nvhien.restaurantmanagement.model.BillItem;
import com.nvhien.restaurantmanagement.model.MenuItem;
import com.nvhien.restaurantmanagement.repository.BillItemRepository;
import com.nvhien.restaurantmanagement.repository.BillRepository;
import com.nvhien.restaurantmanagement.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private BillItemRepository billItemRepository;

    @Autowired
    private BillRepository billRepository;

    private Mapper mapper = new Mapper();

    public ResponseEntity<ResponseObject> create(BillItemRequestObject billItemRequest) {
        try {
            Bill initialBill = billRepository.save(new Bill());
            BillItem billItem = mapper.toBillItem(initialBill, billItemRequest);
            billItemRepository.save(billItem);
            Bill finalBill = billRepository.findById(initialBill.getId()).get();
            Double itemUnitPrice = menuItemRepository.findById(billItemRequest.getMenuItemId()).get().getPrice();
            Double total = itemUnitPrice * billItemRequest.getQuantity();
            finalBill.setTotal(total);
            return ResponseEntity.status(HttpStatus.OK).body(
                    mapper.toResponse(Constant.OK, "Create bill successfully.", billRepository.save(finalBill))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(Constant.FAILED, "Create bill failed.", Constant.EMPTY_STRING)
            );
        }
    }

    public ResponseEntity<ResponseObject> list() {
        try {
            List<BillResponseObject> responseData = new ArrayList<>();
            List<Bill> billList = billRepository.findAll();
            for (Bill bill : billList) {
                Long billId = bill.getId();
                List<BillItem> billItemList = billItemRepository.findAllByBillId(billId);
                List<BillItemResponseObject> billItemResponseObjectList = new ArrayList<>();
                for (BillItem billItem : billItemList) {
                    Long menuItemId = billItem.getMenuItemId();
                    MenuItem menuItem = menuItemRepository.findById(menuItemId).get();
                    BillItemResponseObject billItemResponseObject = mapper.toBillItemResponse(menuItem, billItem);
                    billItemResponseObjectList.add(billItemResponseObject);
                }
                BillResponseObject billResponseObject = mapper.toBillResponse(bill, billItemResponseObjectList);
                responseData.add(billResponseObject);
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    mapper.toResponse(Constant.OK, "List bill successfully.", responseData)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    mapper.toResponse(Constant.FAILED, "List bill failed.", Constant.EMPTY_STRING)
            );
        }
    }

    public ResponseEntity<ResponseObject> addItem(Long billId, BillItemRequestObject billItemRequestObject) {
        try {
            Bill bill = billRepository.findById(billId).get();
            BillItem newBillItem = mapper.toBillItem(bill, billItemRequestObject);
            Double itemUnitPrice = menuItemRepository.findById(billItemRequestObject.getMenuItemId()).get().getPrice();
            Double newTotal = bill.getTotal() + itemUnitPrice * billItemRequestObject.getQuantity();
            bill.setTotal(newTotal);
            billRepository.save(bill);
            return ResponseEntity.status(HttpStatus.OK).body(
                    mapper.toResponse(Constant.OK, "Add item into bill successfully.", billItemRepository.save(newBillItem))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    mapper.toResponse(Constant.FAILED, "Add item into bill failed.", Constant.EMPTY_STRING)
            );
        }
    }

    public ResponseEntity<ResponseObject> deleteItem(Long billId, Long itemId) {
        try {
            Optional<BillItem> deletedItemOptional = billItemRepository.findById(itemId);
            if (!deletedItemOptional.isPresent()){
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        mapper.toResponse(Constant.FAILED, "Bill item does not exist.", Constant.EMPTY_STRING)
                );
            } else {
                BillItem deletedItem = deletedItemOptional.get();
                Optional<Bill> updatedBillOptional = billRepository.findById(billId);
                if (!updatedBillOptional.isPresent()) {
                    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            mapper.toResponse(Constant.FAILED, "Bill does not exist.", Constant.EMPTY_STRING)
                    );
                } else {
                    Bill updatedBill = updatedBillOptional.get();
                    Double itemUnitPrice = menuItemRepository.findById(deletedItem.getMenuItemId()).get().getPrice();
                    Double newTotal = updatedBill.getTotal() - itemUnitPrice * deletedItem.getQuantity();
                    updatedBill.setTotal(newTotal);
                    billItemRepository.deleteById(itemId);
                    return ResponseEntity.status(HttpStatus.OK).body(
                            new ResponseObject(Constant.OK, "Delete item successfully.", billRepository.save(updatedBill))
                    );
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(Constant.FAILED, "Delete item from bill failed.", Constant.EMPTY_STRING)
            );
        }
    }
}
