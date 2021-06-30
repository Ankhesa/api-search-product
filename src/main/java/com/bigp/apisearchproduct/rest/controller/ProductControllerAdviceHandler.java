package com.bigp.apisearchproduct.rest.controller;

import com.bigp.apisearchproduct.exception.CategoryIdNotFoundException;
import com.bigp.apisearchproduct.exception.ProductOutOfStockException;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ProductControllerAdviceHandler {

    @ExceptionHandler(value = {ProductOutOfStockException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleProductOutOfStockException(ProductOutOfStockException productOutOfStockException) {
        Map<String, String> statusMap = Maps.newHashMap();
        statusMap.put("message", productOutOfStockException.getMessage());

        return new ResponseEntity<>(statusMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CategoryIdNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleCategoryIdNotFoundException(CategoryIdNotFoundException categoryIdNotFoundException) {
        Map<String, String> statusMap = Maps.newHashMap();
        statusMap.put("message", categoryIdNotFoundException.getMessage());

        return new ResponseEntity<>(statusMap, HttpStatus.NOT_FOUND);
    }
}
