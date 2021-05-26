package com.bigp.apisearchproduct.rest.controller.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ProductDetailsResponse {
    private final String productId;
    private final String description;
    private final int quantity;
    private final String category;
}
