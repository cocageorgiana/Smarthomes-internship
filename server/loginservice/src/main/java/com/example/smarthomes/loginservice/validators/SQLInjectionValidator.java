package com.example.smarthomes.loginservice.validators;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLInjectionValidator implements ConstraintValidator<SQLInjectionAnnotation, String> {

    /**
     * Validator class that checks if the imputed text contains malicious SQL code  using Regular Expressions
     */

    private static final String SQLINJ_PATTERN = "('(''|[^'])*')|(;)|(\b(ALTER|CREATE|DELETE|DROP|EXEC(UTE){0,1}|INSERT( +INTO){0,1}|MERGE|SELECT|UPDATE|UNION( +ALL){0,1})\b)  ";

    /**
     * Actual checking if the inputed text contains using malicious JavaScript code using the regular expression pattern defined
     * @param value the text that we want to check
     * @param context the context
     * @return true or false depending if the text matches the pattern for SQL injection attacks
     */

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(SQLINJ_PATTERN);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
