package com.chunpat.fengxiuapi.exception;

public class ParameterException extends HttpException{
    public ParameterException(int code){
        this.code = code;
        this.codeHttpStatus = 400;
    }
}
