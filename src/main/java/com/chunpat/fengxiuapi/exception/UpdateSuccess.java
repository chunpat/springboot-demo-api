package com.chunpat.fengxiuapi.exception;

public class UpdateSuccess extends HttpException{
    public UpdateSuccess(){
        this.code = 0;
        this.codeHttpStatus = 200;
    }
}
