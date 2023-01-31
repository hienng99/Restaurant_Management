package com.nvhien.restaurantmanagement.service;

import com.nvhien.restaurantmanagement.model.entity.Item;
import com.nvhien.restaurantmanagement.model.exception.ItemNameAlreadyExistException;
import com.nvhien.restaurantmanagement.model.exception.ItemNotFoundException;
import com.nvhien.restaurantmanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item> listAll() {
        return repository.findAll();
    }

    public void create(Item item) throws ItemNameAlreadyExistException {
        String itemName = item.getName();
        if (repository.existsByName(itemName)) {
            throw new ItemNameAlreadyExistException("The item with name=" + itemName + " is already exist.");
        }
        repository.save(item);
    }

    public void update(Long id, Item newItem) throws ItemNotFoundException {
        if (repository.existsById(id)) {
            repository.findById(id).map(item -> {
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setImage(newItem.getImage());
                item.setPrice(newItem.getPrice());
                return repository.save(item);
            });
        } else {
            throw new ItemNotFoundException("Cannot find item with ID=" + id + " to update.");
        }
    }

    public Item get(Long id) throws ItemNotFoundException {
        Optional<Item> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ItemNotFoundException("Item does not exist.");
    }

    public void delete(Long id) throws ItemNotFoundException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ItemNotFoundException("Cannot find item with ID=" + id + " to delete.");
        }
    }
}
