package com.chunpat.fengxiuapi.exception;

public class DeleteSuccess extends HttpException{
    public DeleteSuccess(){
        this.code = 0;
        this.codeHttpStatus = 200;
    }
}
