package com.nvhien.restaurantmanagement.model.mapper;

import com.nvhien.restaurantmanagement.model.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityMapper {
    public static ResponseEntity success(Response body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity notFound(Response body) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
