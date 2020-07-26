package com.chunpat.fengxiuapi.core;

import com.chunpat.fengxiuapi.exception.CreateSuccess;
import com.chunpat.fengxiuapi.exception.DeleteSuccess;
import com.chunpat.fengxiuapi.exception.UpdateSuccess;

public class UnifyResponse {
    private int code = 0;
    private String message = "";
    private String request = "";

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequest() {
        return request;
    }

    public UnifyResponse(int code, String message,String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }

    public static void createSuccess(){
        throw new CreateSuccess();
    }

    public static void updateSuccess(){
        throw new UpdateSuccess();
    }

    public static void deleteSuccess(){
        throw new DeleteSuccess();
    }
}
