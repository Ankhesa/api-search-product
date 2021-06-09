package com.bigp.apisearchproduct.client;

import com.bigp.apisearchproduct.client.domain.ProductResponse;
import com.bigp.apisearchproduct.rest.controller.domain.request.ProductRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {
    private final RestTemplate restTemplate;


    public ProductServiceClient(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .rootUri("http://localhost:9082/ws/api/product-service-asp/v1")
                .build();
    }

    public ProductResponse getProductsByCategoryId(Long categoryId) {
        return restTemplate.getForObject("/products/{categoryId}",
                ProductResponse.class,categoryId);
    }
}
