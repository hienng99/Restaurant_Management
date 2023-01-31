package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.common.Constant;
import com.nvhien.restaurantmanagement.model.dto.ResponseBody;

public class ResponseBodyMapper {
    public static <T> ResponseBody create(int code, String message, T data) {
        return new ResponseBody(code, message, data);
    }
}
