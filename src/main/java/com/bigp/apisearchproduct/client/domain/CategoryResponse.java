package com.bigp.apisearchproduct.client.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryResponse {
    private  List<Category> categories;
}
