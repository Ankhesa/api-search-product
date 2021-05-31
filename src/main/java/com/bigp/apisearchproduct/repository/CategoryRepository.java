package com.bigp.apisearchproduct.repository;

import com.bigp.apisearchproduct.client.CategoryServiceClient;
import com.bigp.apisearchproduct.rest.controller.domain.response.CategoryDetailsResponse;
import com.bigp.apisearchproduct.rest.controller.domain.response.ProductDetailsResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepository {
    private final CategoryServiceClient categoryServiceClient;

    public CategoryRepository(CategoryServiceClient categoryServiceClient) {
        this.categoryServiceClient = categoryServiceClient;
    }

    public String getCategoryDetails(String sort) {
        return categoryServiceClient.getCategory(sort);
    }

    public List<ProductDetailsResponse> getActiveCategories() {
        return categoryServiceClient.getActiveCategories().getCategories().stream().sorted()
                .map(category -> new CategoryDetailsResponse(category.getCategoryId(), category.getName(), category.getRank()))
                .collect(Collectors.toList());
    }
}
