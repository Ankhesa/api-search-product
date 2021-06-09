package com.bigp.apisearchproduct.client.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    private String description;
    private Long quantity;
    private Long categoryId;
}
