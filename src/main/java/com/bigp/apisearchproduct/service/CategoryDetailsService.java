package com.bigp.apisearchproduct.service;

import com.bigp.apisearchproduct.repository.CategoryRepository;
import com.bigp.apisearchproduct.rest.controller.domain.request.CategorySort;
import com.bigp.apisearchproduct.rest.controller.domain.response.CategoryDetailsResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class CategoryDetailsService {
    private final CategoryRepository categoryRepository;

    public CategoryDetailsService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDetailsResponse> getCategories(CategorySort sortType) {
        return categoryRepository.getActiveCategories().stream()
                .sorted((categoryDetailsResponse, t1) ->
                        getComparator(sortType).compare(categoryDetailsResponse, t1))
                .collect(Collectors.toList());
    }

    private Comparator<CategoryDetailsResponse> getComparator(CategorySort sortType) {
        if (CategorySort.RANKED.equals(sortType)) {
            return (h1, h2) -> h1.getRank().compareTo(h2.getRank());
        }else if(CategorySort.ALPHABETIC.equals(sortType)) {
            return (h1, h2) -> h1.getName().compareTo(h2.getName());
        }
        return (categoryDetailsResponse, t1) ->
                categoryDetailsResponse.getName().compareTo(t1.getName());
    }


}
