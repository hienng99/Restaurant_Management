package com.nvhien.restaurantmanagement.controller;

import com.nvhien.restaurantmanagement.service.BillService;
import com.nvhien.restaurantmanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/bill")
public class BillController {
    @Autowired
    private BillService billService;

//    @Autowired
//    private BillItemService billItemService;

    @Autowired
    private ItemService itemService;

//    @GetMapping("/")
//    public ResponseEntity listAll() {
//        try {
//            List<BillResponseObject> responseData = new ArrayList<>();
//            List<Bill> billList = billService.listAll();
//            for (Bill bill : billList) {
//                Long billId = bill.getId();
//                List<BillItem> billItemList = billItemService.findAllByBillId(billId);
//                List<BillItemResponseObject> billItemResponseObjectList = new ArrayList<>();
//                for (BillItem billItem : billItemList) {
//                    Long itemId = billItem.getItem().getId();
//                    Item item = itemService.get(itemId);
//                    BillItemResponseObject billItemResponseObject = BillItemResponseMapper.fromMenuItemAndBillItem(item, billItem);
//                    billItemResponseObjectList.add(billItemResponseObject);
//                }
//                BillResponseObject billResponseObject = BillResponseMapper.fromBillAndBillItemResponse(bill, billItemResponseObjectList);
//                responseData.add(billResponseObject);
//            }
//            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("List all bills successfully.", responseData));
//        } catch (ItemNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create("Error when create response.", Constant.EMPTY_STRING));
//        }
//    }
//
//    @PostMapping("/")
//    public ResponseEntity createBill(@RequestBody BillItemRequestObject billItemRequest) {
//        try {
//            Item item = itemService.get(billItemRequest.getItemId());
//            Bill initialBill = billService.save(new Bill());
//            BillItem billItem = BillItemRequestMapper.toBillItem(initialBill, item, billItemRequest);
//            billItemService.save(billItem);
//            Bill finalBill = billService.get(initialBill.getId());
//            Double itemUnitPrice = item.getPrice();
//            Double total = itemUnitPrice * billItemRequest.getQuantity();
//            Bill updatedBill = billService.updateTotal(initialBill.getId(), total);
//            List<BillItemResponseObject> billItemResponseObjectList = new ArrayList<>();
//            BillItemResponseObject billItemResponseObject = BillItemResponseMapper.fromMenuItemAndBillItem(item, billItem);
//            billItemResponseObjectList.add(billItemResponseObject);
//            BillResponseObject billResponseObject = BillResponseMapper.fromBillAndBillItemResponse(updatedBill, billItemResponseObjectList);
//            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Create bill successfully.", billResponseObject));
//        } catch (ItemNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        } catch (BillNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        }
//    }
//
//    @PostMapping("/{id}")
//    public ResponseEntity addItemIntoBill(@PathVariable Long id, @RequestBody BillItemRequestObject billItemRequest) {
//        try {
//            Bill bill = billService.get(id);
//            Item item = itemService.get(billItemRequest.getItemId());
//            BillItem newBillItem = BillItemRequestMapper.toBillItem(bill, item, billItemRequest);
//            Double itemUnitPrice = item.getPrice();
//            Double newTotal = bill.getTotal() + itemUnitPrice * billItemRequest.getQuantity();
//            billItemService.save(newBillItem);
//            billService.updateTotal(id, newTotal);
//            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Add item into bill successfully.", Constant.EMPTY_STRING));
//        } catch (ItemNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        } catch (BillNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        }
//    }
//
//    @DeleteMapping("/{billId}/{itemId}")
//    public ResponseEntity deleteItemFromBill(@PathVariable("billId") Long billId, @PathVariable("itemId") Long itemId) {
//        try {
//            Bill updatedBill = billService.get(billId);
//            BillItem deletedItem = billItemService.get(itemId);
//            Item item = deletedItem.getItem();
//            Double itemUnitPrice = item.getPrice();
//            Double newTotal = updatedBill.getTotal() - itemUnitPrice * deletedItem.getQuantity();
//            billService.updateTotal(billId, newTotal);
//            billItemService.delete(itemId);
//            return ResponseEntityMapper.createSuccessResponse(ResponseBodyMapper.create("Delete Item from bill successfully.", Constant.EMPTY_STRING));
//        } catch (BillItemNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        } catch (BillNotFoundException e) {
//            return ResponseEntityMapper.createFailedResponse(ResponseBodyMapper.create(e.getMessage(), Constant.EMPTY_STRING));
//        }
//    }
}

