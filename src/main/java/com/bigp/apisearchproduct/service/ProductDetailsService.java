package com.bigp.apisearchproduct.service;

import com.bigp.apisearchproduct.client.domain.Product;
import com.bigp.apisearchproduct.repository.ProductRepository;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductDetailsResponse;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsService {
    private final ProductRepository productRepository;
    private final StockService stockService;

    public ProductDetailsService(ProductRepository productRepository, StockService stockService) {
        this.productRepository = productRepository;
        this.stockService = stockService;
    }

    public List<ProductDetailsResponse> getProducts(Long categoryId) {
        return productRepository.getProductsByCategoryId(categoryId);
    }

    public ProductResponse getProduct(Long productId) {
        Product product =  productRepository.getProductById(productId);
        Integer stock = stockService.getStock(productId);
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .categoryId(product.getCategoryId())
                .stock(stock)
                .lastUnits(calculateLastUnits(stock))
                .build();
    }

    private Boolean calculateLastUnits(Integer stock) {
        return stock < 20;
    }
}
