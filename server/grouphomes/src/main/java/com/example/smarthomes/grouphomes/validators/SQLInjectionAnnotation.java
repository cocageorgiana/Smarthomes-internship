package com.example.smarthomes.grouphomes.validators;

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

    String message() default "You have tried to SQL inject";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
