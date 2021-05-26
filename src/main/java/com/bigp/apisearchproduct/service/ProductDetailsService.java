package com.bigp.apisearchproduct.service;

import com.bigp.apisearchproduct.repository.ProductRepository;
import com.bigp.apisearchproduct.rest.controller.domain.request.ProductDetailsRequest;
import com.bigp.apisearchproduct.rest.controller.domain.request.ProductsRequest;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsService {
    private final ProductRepository productRepository;

    public ProductDetailsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDetailsResponse getProductDetails(ProductDetailsRequest productDetailsRequest) {
        return new ProductDetailsResponse(productDetailsRequest.getProductId(), productRepository
                .getProductDetails(productDetailsRequest.getProductId()), 1, "0");
    }

    public List<ProductDetailsResponse> getProducts(ProductsRequest productsRequest) {
        return productRepository.getProducts(productsRequest);
    }
}
