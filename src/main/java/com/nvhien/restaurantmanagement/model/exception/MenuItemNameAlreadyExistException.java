package com.nvhien.restaurantmanagement.model.exception;

public class MenuItemNameAlreadyExistException extends Throwable{
    public MenuItemNameAlreadyExistException(String message) {
        super(message);
    }
}
