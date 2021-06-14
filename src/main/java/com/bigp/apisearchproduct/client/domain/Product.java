package com.bigp.apisearchproduct.client.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    private String description;
    private String name;
    private Long categoryId;
}
