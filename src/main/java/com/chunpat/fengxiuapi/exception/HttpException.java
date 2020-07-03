package com.chunpat.fengxiuapi.exception;

import javax.xml.ws.http.HTTPException;

public class HttpException extends RuntimeException {
    protected int code;
    protected String message;
    protected int codeHttpStatus;

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCodeHttpStatus() {
        return codeHttpStatus;
    }
}
