package com.nvhien.restaurantmanagement.model.dto;

public class ResponseBody {
    private String message;
    private Object data;

    public ResponseBody() {
    }

    public ResponseBody(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
