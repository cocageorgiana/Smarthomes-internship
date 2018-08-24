package com.example.smarthomes.register.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameAnnotation, String > {

    private final String NAME_PATTERN = "[A-Za-z]";

    @Override
    public void initialize(NameAnnotation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
