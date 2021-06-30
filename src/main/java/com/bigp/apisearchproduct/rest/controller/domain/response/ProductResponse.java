package com.bigp.apisearchproduct.rest.controller.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Integer stock;
    private Boolean lastUnits;
}
