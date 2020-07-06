package com.chunpat.fengxiuapi.exception;

import lombok.Getter;

import javax.xml.ws.http.HTTPException;

@Getter
public class HttpException extends RuntimeException {
    protected int code;
    protected String message;
    protected int codeHttpStatus;
}
