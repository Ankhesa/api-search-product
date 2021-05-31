package com.bigp.apisearchproduct.service;

import com.bigp.apisearchproduct.repository.CategoryRepository;
import com.bigp.apisearchproduct.rest.controller.domain.request.CategoryDetailsRequest;
import com.bigp.apisearchproduct.rest.controller.domain.request.CategorySort;
import com.bigp.apisearchproduct.rest.controller.domain.response.CategoryDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDetailsService {
    private final CategoryRepository categoryRepository;

    public CategoryDetailsService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDetailsResponse getCategoryDetails(CategoryDetailsRequest categoryDetailsRequest) {
        return new CategoryDetailsResponse(categoryDetailsRequest.getSort(), categoryRepository
                .getCategoryDetails(categoryDetailsRequest.getSort()), "1");
    }

    public List<CategoryDetailsResponse> getCategories(CategorySort sortType) {
        return categoryRepository.getActiveCategories();
    }
}
