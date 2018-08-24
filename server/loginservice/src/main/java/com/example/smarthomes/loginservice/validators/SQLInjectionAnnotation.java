package com.example.smarthomes.loginservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = {SQLInjectionValidator.class})
public @interface SQLInjectionAnnotation {

    String message() default "Endpoint user has tried to sql inject";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}