package com.nvhien.restaurantmanagement.service;

import com.nvhien.restaurantmanagement.model.entity.BillItem;
import com.nvhien.restaurantmanagement.model.exception.BillItemNotFoundException;
import com.nvhien.restaurantmanagement.repository.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillItemService {
    @Autowired
    private BillItemRepository repository;

    public List<BillItem> listAll() {
        return repository.findAll();
    }

    public void save(BillItem item) {
        repository.save(item);
    }

    public BillItem get(Long id) throws BillItemNotFoundException {
        Optional<BillItem> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new BillItemNotFoundException("Cannot find bill item with ID=" + id);
    }

    public void delete(Long id) throws BillItemNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new BillItemNotFoundException("Cannot find bill item with ID=" + id);
        }
    }

    public List<BillItem> findAllByBillId(Long id) {
        return repository.findAllByBillId(id);
    }
}
