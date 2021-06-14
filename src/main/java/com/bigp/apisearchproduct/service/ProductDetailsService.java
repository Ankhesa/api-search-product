package com.bigp.apisearchproduct.service;

import com.bigp.apisearchproduct.repository.ProductRepository;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDetailsService {
    private final ProductRepository productRepository;

    public ProductDetailsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDetailsResponse> getProducts(Long categoryId) {
        return productRepository.getProductsByCategoryId(categoryId);
    }

    public List<ProductDetailsResponse> getProduct(Long productId) {
        return productRepository.getProductById(productId);
    }
}
