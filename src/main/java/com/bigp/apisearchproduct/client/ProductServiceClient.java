package com.bigp.apisearchproduct.client;

import com.bigp.apisearchproduct.client.domain.Product;
import com.bigp.apisearchproduct.client.domain.ProductResponse;
import com.bigp.apisearchproduct.exception.CategoryIdNotFoundException;
import com.bigp.apisearchproduct.rest.controller.domain.request.ProductRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
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
        try {
            return restTemplate.getForObject("/products/{categoryId}",
                    ProductResponse.class,categoryId);
        } catch (RestClientException restClientException) {
            throw new CategoryIdNotFoundException(restClientException.getMessage());
        }
    }


    public Product getProductById(Long productId) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setIdProduct(productId);
        return restTemplate.getForObject("/product/{idProduct}",
                Product.class, productId);
    }
}
