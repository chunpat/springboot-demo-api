package com.chunpat.fengxiuapi.exception;

public class ForbiddenException extends HttpException{
    public ForbiddenException(int code){
        this.code = code;
        this.codeHttpStatus = 403;
    }

    public ForbiddenException(){
        this.code = 10006;
        this.codeHttpStatus = 403;
    }
}
