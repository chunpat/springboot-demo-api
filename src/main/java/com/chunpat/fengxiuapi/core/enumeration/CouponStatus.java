package com.chunpat.fengxiuapi.core.enumeration;

import com.chunpat.fengxiuapi.exception.ParameterException;

public enum CouponStatus {
    AVAILABLE(1,"未使用"),
    USED(2,"已使用"),
    OUTDATE(3,"已过期");

    private Integer value;


    public Integer getValue(){
        return this.value;
    };

    CouponStatus(Integer value, String description){
        if(value > 3 || value < 1){
            throw new ParameterException(10004);
        }
        this.value = value;
    }
}
