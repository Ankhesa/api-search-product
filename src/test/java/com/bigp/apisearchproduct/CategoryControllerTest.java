package com.bigp.apisearchproduct;

import com.bigp.apisearchproduct.rest.controller.CategoryController;
import com.bigp.apisearchproduct.rest.controller.domain.request.CategorySort;
import com.bigp.apisearchproduct.rest.controller.domain.response.CategoryDetailsResponse;
import com.bigp.apisearchproduct.service.CategoryDetailsService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
    @Mock
    private CategoryDetailsService categoryService;
    @Mock
    private CategorySort sortType;
    @Mock
    private CategoryDetailsResponse categoryDetailsResponse;
    @InjectMocks
    private CategoryController categoryController;

    @Test
    void shouldCallCategoryService() {

        Mockito.when(categoryService.getCategories(sortType))
                .thenReturn(Lists.newArrayList(categoryDetailsResponse));

        ResponseEntity<List<CategoryDetailsResponse>> response = categoryController
                .getSortedCategories(sortType);

        Mockito.verify(categoryService, Mockito.times(1))
                .getCategories(sortType);
        assertThat(response.getBody().get(0), is(categoryDetailsResponse));
    }

    @Test
    void shouldThrowExceptionWhenCategoryServiceError() {

        Mockito.when(categoryService.getCategories(sortType))
                .thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> categoryController
                .getSortedCategories(sortType));
    }


}