package com.bigp.apisearchproduct.rest.controller;

import com.bigp.apisearchproduct.rest.controller.domain.request.ProductRequest;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductDetailsResponse;
import com.bigp.apisearchproduct.service.ProductDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    private final ProductDetailsService productDetailsService;

    public ProductController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @PostMapping("/products")
    @ResponseBody
    public ResponseEntity<List<ProductDetailsResponse>> getProducts(@RequestBody @Valid ProductRequest productRequest) {
        return new ResponseEntity<>(productDetailsService.getProducts(productRequest), HttpStatus.OK);
    }
}
