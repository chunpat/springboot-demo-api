package com.chunpat.fengxiuapi.core.enumeration;

import com.chunpat.fengxiuapi.exception.ParameterException;

import javax.validation.constraints.Max;

public enum LoginType {
//    USER_WX,USER_EMAIL;
    USER_WX(0,"微信登录"),
    USER_EMAIL(1,"邮箱登录");

    private Integer value;

    //todo 大于1不知道怎么捕抓异常
    LoginType(Integer value,String description){
        if(value > 1){
            throw new ParameterException(10004);
        }
        this.value = value;
    }
}
