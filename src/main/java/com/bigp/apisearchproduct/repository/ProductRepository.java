package com.bigp.apisearchproduct.repository;

import com.bigp.apisearchproduct.client.ProductServiceClient;
import com.bigp.apisearchproduct.rest.controller.domain.request.ProductsRequest;
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

    public String getProductDetails(String productId) {
        return productServiceClient.getProduct(productId);
    }

    public List<ProductDetailsResponse> getProducts(ProductsRequest productsRequest) {
        return productServiceClient.getProducts().getProducts().stream()
                .filter(product -> product.getCategoryId().equals(productsRequest.getCategoryId()))
                .map(product -> new ProductDetailsResponse(product.getId(), product.getDescription(), 1,
                        product.getCategoryId()))
                .collect(Collectors.toList());
    }
}
