package com.bigp.apisearchproduct.rest.controller.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CategoryDetailsResponse {
    private final String id;
    private final String name;
    private String ranking;
    private String description;
}
