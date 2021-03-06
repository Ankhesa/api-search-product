package com.bigp.apisearchproduct.client;

import com.bigp.apisearchproduct.client.domain.CategoryResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CategoryServiceClient {
    private final RestTemplate restTemplate;

    public CategoryServiceClient(RestTemplateBuilder builder) {
        this.restTemplate = builder
        .rootUri("http://localhost:9082/ws/api/product-service-asp/v1")
                .build();
    }

    public CategoryResponse getActiveCategories() {
        return restTemplate.getForObject("/categories?active=true", CategoryResponse.class);
    }
}
