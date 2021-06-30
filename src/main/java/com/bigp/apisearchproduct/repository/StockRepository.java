package com.bigp.apisearchproduct.repository;


import com.bigp.apisearchproduct.client.StockServiceClient;
import com.bigp.apisearchproduct.client.domain.StockResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StockRepository {
    private final StockServiceClient stockServiceClient;

    public StockRepository(StockServiceClient stockServiceClient) {
        this.stockServiceClient = stockServiceClient;
    }

    public StockResponse getStockByProductId(Long productId) {
        return stockServiceClient.getStockByProductId(productId);
    }
}
