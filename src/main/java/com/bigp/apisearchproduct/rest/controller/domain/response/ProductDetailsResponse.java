package com.bigp.apisearchproduct.rest.controller.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ProductDetailsResponse {
    private final String id;
    private final String description;
    private String name;
    private final Long categoryId;
}
