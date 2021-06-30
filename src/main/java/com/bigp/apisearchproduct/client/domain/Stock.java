package com.bigp.apisearchproduct.client.domain;

import lombok.Data;

@Data
public class Stock {
    private Long id;
    private Long productId;
    private int quantity;
    private boolean flag;
}
