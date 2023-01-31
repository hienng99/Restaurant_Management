package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityMapper {
    public static ResponseEntity createSuccessResponse(ResponseBody body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity createFailedResponse(ResponseBody body) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(body);
    }
}
