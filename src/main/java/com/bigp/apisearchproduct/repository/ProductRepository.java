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



    public List<ProductDetailsResponse> getProductsByCategoryId(ProductRequest productRequest) {
        return productServiceClient.getProductsByCategoryId(productRequest.getCategoryId()).getProducts().stream()
                .filter(product -> product.getCategoryId().equals(productRequest.getCategoryId()))
                .map(product -> new ProductDetailsResponse(product.getId(), product.getDescription(), product.getQuantity(),
                        product.getCategoryId()))
                .collect(Collectors.toList());
    }
}
