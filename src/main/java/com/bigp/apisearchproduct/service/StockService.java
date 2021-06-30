package com.bigp.apisearchproduct.service;


import com.bigp.apisearchproduct.exception.ProductOutOfStockException;
import com.bigp.apisearchproduct.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Integer getStock(Long productId) {
        int stock = stockRepository.getStockByProductId(productId).getQuantity();
        if(stock < 1) {
            throw  new ProductOutOfStockException("ProductId " + productId + " is out of stock");
        }
        return stock;
    }
}
