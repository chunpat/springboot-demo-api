package com.chunpat.fengxiuapi.dto.validator;

import org.thymeleaf.util.Validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Validation;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Constraint(validatedBy = TokenPasswordValidator.class)
public @interface TokenPassword {
    String message() default "字段不符合要求";

    int min() default 6;
    int max() default 32;
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
