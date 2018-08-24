package com.example.smarthomes.register.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {PasswordValidator.class})
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface PasswordAnnotation {

    String message() default "The password does not respect the rules";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
