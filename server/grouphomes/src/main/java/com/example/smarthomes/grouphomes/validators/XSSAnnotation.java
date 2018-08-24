package com.example.smarthomes.grouphomes.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = {XSSValidator.class})
public @interface XSSAnnotation {

    String message() default "You don't have any power here you XSS Attacker";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
