package com.bigp.apisearchproduct.repository;

import com.bigp.apisearchproduct.client.ProductServiceClient;
import com.bigp.apisearchproduct.rest.controller.domain.request.ProductRequest;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductDetailsResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final ProductServiceClient productServiceClient;

    public ProductRepository(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }



    public List<ProductDetailsResponse> getProductsByCategoryId(Long categoryId) {
        return productServiceClient.getProductsByCategoryId(categoryId).getProducts().stream()
                .filter(product -> product.getCategoryId().equals(categoryId))
                .map(product -> new ProductDetailsResponse(product.getId(), product.getDescription(), product.getQuantity(),
                        product.getCategoryId()))
                .collect(Collectors.toList());
    }
}
