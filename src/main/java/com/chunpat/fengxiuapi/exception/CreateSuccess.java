package com.chunpat.fengxiuapi.exception;

public class CreateSuccess extends HttpException{
    public CreateSuccess(){
        this.code = 0;
        this.codeHttpStatus = 201;
    }
}
