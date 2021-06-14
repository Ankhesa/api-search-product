package com.bigp.apisearchproduct.rest.controller;

import com.bigp.apisearchproduct.rest.controller.domain.request.ProductRequest;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductDetailsResponse;
import com.bigp.apisearchproduct.service.ProductDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    private final ProductDetailsService productDetailsService;

    public ProductController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<List<ProductDetailsResponse>> getProducts(@PathVariable @Valid Long categoryId) {
        return new ResponseEntity<>(productDetailsService.getProducts(categoryId), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductDetailsResponse>> getProduct(@PathVariable @Valid Long productId) {
        return new ResponseEntity<>(productDetailsService.getProduct(productId),HttpStatus.OK);
    }
}
