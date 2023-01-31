package com.nvhien.restaurantmanagement.service;

import com.nvhien.restaurantmanagement.model.entity.Bill;
import com.nvhien.restaurantmanagement.model.exception.BillNotFoundException;
import com.nvhien.restaurantmanagement.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    private BillRepository repository;

    public List<Bill> listAll() {
        return repository.findAll();
    }

    public Bill save(Bill bill) {
        return repository.save(bill);
    }

    public Bill get(Long id) throws BillNotFoundException {
        Optional<Bill> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new BillNotFoundException("Cannot find bill with ID: " + id);
    }

    public Bill updateTotal(Long id, Double newTotal) throws BillNotFoundException {
        Optional<Bill> result = repository.findById(id);
        if (result.isPresent()) {
            Bill bill = result.get();
            bill.setTotal(newTotal);
            return repository.save(bill);
        }
        throw new BillNotFoundException("Cannot find bill with ID: " + id + " to update.");
    }
}
