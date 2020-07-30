package com.chunpat.fengxiuapi.core.enumeration;

import com.chunpat.fengxiuapi.exception.ParameterException;

import java.util.stream.Stream;

public enum CouponType {
    FULL_MINUS(1,"满减卷"),
    FULL_OFF(2,"满减折扣卷"),
    NO_THRESHOLD(3,"无门槛减除卷");

    private Integer value;

    public Integer getValue(){
        return this.value;
    };

    public static CouponType toType(int status){
        return Stream.of(CouponType.values()).filter(c->c.value == status).findAny().orElse(null);
    };

    CouponType(Integer value, String description){
        if(value > 3 || value < 1){
            throw new ParameterException(10004);
        }
        this.value = value;
    }
}
