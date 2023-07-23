package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.Response;

public class ResponseBodyMapper {
    public static <T> Response create(int code, String message, T data) {
        return new Response(code, message, data);
    }
}
