package com.bigp.apisearchproduct.rest.controller.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
//@CategoryAndNameValidation
public class ProductRequest {
    private Long categoryId;
/*    @NotNull (message = "categoryId cannot be null")
    private CategoryType categoryId;
    @Size (min = 3)
    @NotNull
    @Pattern (regexp = "[a-zA-Z]+", message = "Only alphanumeric")
    private String name; */
}
