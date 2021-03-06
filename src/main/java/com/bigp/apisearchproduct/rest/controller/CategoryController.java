package com.bigp.apisearchproduct.rest.controller;

import com.bigp.apisearchproduct.rest.controller.domain.request.CategorySort;
import com.bigp.apisearchproduct.rest.controller.domain.response.CategoryDetailsResponse;
import com.bigp.apisearchproduct.service.CategoryDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryDetailsService categoryDetailsService;

    public CategoryController(CategoryDetailsService categoryDetailsService) {
        this.categoryDetailsService = categoryDetailsService;
    }

    @GetMapping("/categories/{sort}")
    public ResponseEntity<List<CategoryDetailsResponse>> getSortedCategories(@PathVariable @Valid CategorySort sort) {
        return new ResponseEntity<>(categoryDetailsService.getCategories(sort), HttpStatus.OK);
    }

}
