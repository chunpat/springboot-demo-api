package com.chunpat.fengxiuapi.core.enumeration;

import com.chunpat.fengxiuapi.exception.ParameterException;

import java.util.stream.Stream;

public enum CouponStatus {
    AVAILABLE(1,"未使用"),
    USED(2,"已使用"),
    OUTDATE(3,"已过期");

    private Integer value;


    public Integer getValue(){
        return this.value;
    };

    public static CouponStatus toType(int status){
        return Stream.of(CouponStatus.values()).filter(c->c.value == status).findAny().orElse(null);
    };

    CouponStatus(Integer value, String description){
        if(value > 3 || value < 1){
            throw new ParameterException(10004);
        }
        this.value = value;
    }
}
