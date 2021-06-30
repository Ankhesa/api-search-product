package com.bigp.apisearchproduct.repository;

import com.bigp.apisearchproduct.client.CategoryServiceClient;
import com.bigp.apisearchproduct.rest.controller.domain.response.CategoryDetailsResponse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepository {
    private final CategoryServiceClient categoryServiceClient;

    public CategoryRepository(CategoryServiceClient categoryServiceClient) {
        this.categoryServiceClient = categoryServiceClient;
    }

    public List<CategoryDetailsResponse> getActiveCategories() {
        return categoryServiceClient.getActiveCategories().getCategories().stream()
                .map(category -> new CategoryDetailsResponse(category.getId(), category.getName(), category.getRanking(), category.getDescription()))
                .collect(Collectors.toList());
    }
}
