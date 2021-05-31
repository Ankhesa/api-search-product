package com.bigp.apisearchproduct.rest.controller.validation;


import com.bigp.apisearchproduct.rest.controller.domain.request.ProductsRequest;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

public class CategoryAndNameValidator implements
        ConstraintValidator<CategoryAndNameValidation, ProductsRequest> {

    @Override
    public boolean isValid(ProductsRequest productsRequest,
                           ConstraintValidatorContext cxt) {
        return productsRequest.getCategoryId().equals("1") && productsRequest.getName().equals("hello");
    }

}
