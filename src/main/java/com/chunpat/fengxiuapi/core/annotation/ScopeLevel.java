package com.chunpat.fengxiuapi.core.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
public @interface ScopeLevel {
    int value() default 4;
}
