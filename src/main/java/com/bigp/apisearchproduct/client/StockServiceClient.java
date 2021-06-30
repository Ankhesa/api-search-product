package com.bigp.apisearchproduct.client;


import com.bigp.apisearchproduct.client.domain.StockResponse;
import com.bigp.apisearchproduct.rest.controller.domain.request.StockRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockServiceClient {

    private final RestTemplate restTemplate;

    public StockServiceClient(RestTemplateBuilder builder) {
        restTemplate = builder
                .rootUri("http://localhost:9083/ws/api/stock-service/v1")
                .build();
    }

    public StockResponse getStockByProductId(Long productId) {
        StockRequest stockRequest = new StockRequest();
        stockRequest.setProductId(productId);
        return restTemplate.getForObject("/stock/{productId}",
                StockResponse.class, productId);
    }

}
