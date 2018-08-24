package com.example.smarthomes.loginservice.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSValidator implements ConstraintValidator<XSSAnnotation, String> {

    /**
     * Validator class that checks if the imputed text contains malicious Javascript code using Regular Expressions
     */

    private final String XSS_PATTERN = "<(|\\/|[^\\/>][^>]+|\\/[^>][^>]+)>";

    /**
     * Actual checking if the inputed text contains using malicious JavaScript code using the regular expression pattern defined
     * @param value the text that we want to check
     * @param context the context
     * @return true or false depending if the text matches the pattern for XSS  attacks
     */

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(XSS_PATTERN);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
