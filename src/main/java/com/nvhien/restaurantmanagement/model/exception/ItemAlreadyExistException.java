package com.nvhien.restaurantmanagement.model.exception;

public class ItemAlreadyExistException extends Exception{
    public ItemAlreadyExistException(String message) {
        super(message);
    }
}
