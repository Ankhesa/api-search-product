package com.bigp.apisearchproduct.client.domain;

import com.bigp.apisearchproduct.client.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductResponse {
    private List<Product> products;
}
