package com.example.smarthomes.grouphomes.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSValidator implements ConstraintValidator<XSSAnnotation, String> {

    private final String XSS_PATTERN = "<(|\\/|[^\\/>][^>]+|\\/[^>][^>]+)>";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(XSS_PATTERN);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
