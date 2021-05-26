package com.bigp.apisearchproduct.client;

import com.bigp.apisearchproduct.client.domain.ProductRequest;
import com.bigp.apisearchproduct.client.domain.ProductResponse;
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

    public String getProduct(String productId) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setProductId(productId);
        return restTemplate.postForObject("/product", productRequest, String.class);
    }

    public ProductResponse getProducts() {
        return restTemplate.getForObject("/products", ProductResponse.class);
    }
}
