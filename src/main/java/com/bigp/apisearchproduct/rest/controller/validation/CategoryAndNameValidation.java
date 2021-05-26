package com.bigp.apisearchproduct.rest.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CategoryAndNameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryAndNameValidation {
    String message() default "Category doesnot match name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
