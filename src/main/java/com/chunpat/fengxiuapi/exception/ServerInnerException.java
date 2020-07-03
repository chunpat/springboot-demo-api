package com.chunpat.fengxiuapi.exception;

public class ServerInnerException extends HttpException {
    public ServerInnerException(){
        this.code = 9999;
        this.codeHttpStatus = 500;
    }
}
