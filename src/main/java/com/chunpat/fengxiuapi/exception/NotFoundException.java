package com.chunpat.fengxiuapi.exception;

public class NotFoundException extends HttpException{
    public NotFoundException(int code){
        this.code = code;
        this.codeHttpStatus = 404;
    }
}
