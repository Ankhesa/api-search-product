package com.bigp.apisearchproduct.rest.controller;

import com.bigp.apisearchproduct.rest.controller.domain.request.ProductDetailsRequest;
import com.bigp.apisearchproduct.rest.controller.domain.request.ProductsRequest;
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

    @PostMapping("/product-details")
    @ResponseBody
    public ResponseEntity<ProductDetailsResponse> getProductDetails(@RequestBody @Valid ProductDetailsRequest productDetailsRequest) {
        return new ResponseEntity<>(productDetailsService.getProductDetails(productDetailsRequest), HttpStatus.OK);
    }

    @PostMapping("/products")
    @ResponseBody
    public ResponseEntity<List<ProductDetailsResponse>> getProducts(@RequestBody @Valid ProductsRequest productsRequest) {
        return new ResponseEntity<>(productDetailsService.getProducts(productsRequest), HttpStatus.OK);
    }
}
