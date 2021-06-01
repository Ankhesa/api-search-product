package com.bigp.apisearchproduct.rest.controller;

import com.bigp.apisearchproduct.service.CategoryDetailsService;
import com.bigp.apisearchproduct.exception.CategoryDetailsServiceException;
import com.google.common.collect.Maps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class CategoryControllerAdviceHandler {

    @ExceptionHandler(value = {CategoryDetailsServiceException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleCategoryServiceAdvicer(CategoryDetailsServiceException categoryServiceException) {
        Map<String, String> statusMap = Maps.newHashMap();
        statusMap.put("message", categoryServiceException.getMessage());

        return new ResponseEntity<>(statusMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleException(Exception exception) {
        Map<String, String> statusMap = Maps.newHashMap();
        statusMap.put("message", exception.getMessage());

        return new ResponseEntity<>(statusMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
