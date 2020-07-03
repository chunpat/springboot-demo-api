package com.chunpat.fengxiuapi.dto.validator;

import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TokenPasswordValidator implements ConstraintValidator<TokenPassword,String> {
    private Integer max;
    private Integer min;

    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        this.max = constraintAnnotation.max();
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isEmpty(s)){
            return true;
        }
        return s.length() >= this.min && s.length() <= this.max;
    }
}
