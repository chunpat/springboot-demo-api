package com.chunpat.fengxiuapi.exception;

public class AuthenticatedException extends HttpException{
    public AuthenticatedException(int code){
        this.code = code;
        this.codeHttpStatus = 403;
    }

    public AuthenticatedException(){
        this.code = 10005;
        this.codeHttpStatus = 403;
    }
}
