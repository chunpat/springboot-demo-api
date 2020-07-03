package com.chunpat.fengxiuapi.core;

import com.chunpat.fengxiuapi.core.configuration.ExceptionCodeConfiguration;
import com.chunpat.fengxiuapi.exception.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice{
    @Autowired
    private ExceptionCodeConfiguration exceptionCodes;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest request,Exception e){
        System.out.println(e);
        UnifyResponse response = new UnifyResponse(9999,"服务内部错误", request.getMethod() + ' ' +request.getRequestURI().toString());
        return response;
    }

    @ExceptionHandler(value = HttpException.class)
    @ResponseBody
    public ResponseEntity httpHandleException(HttpServletRequest request,HttpException e){
        UnifyResponse response = new UnifyResponse(e.getCode(),exceptionCodes.getMessage(e.getCode()), request.getMethod() + ' ' +request.getRequestURI().toString());
//        UnifyResponse<> response =
        HttpHeaders headers = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.resolve(e.getCodeHttpStatus());
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(response, headers, httpStatus);
        return r;
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    // 设置响应状态码为400
    public ResponseEntity handleBindGetException(HttpServletRequest request,ConstraintViolationException e) {
        UnifyResponse response = new UnifyResponse(10001,e.getMessage(),request.getMethod() + ' ' +request.getRequestURI().toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        return  r;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    // 设置响应状态码为400
    public ResponseEntity handleBindGetException(HttpServletRequest request,MethodArgumentNotValidException e) {

//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", new Date());

        // 获取所有异常
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = formatErrorsMessage(errors);
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//        body.put("errors", errors);
//        for(MethodArgumentNotValidException error: e.get()){
//
//        }

        UnifyResponse response = new UnifyResponse(10001,message,request.getMethod() + ' ' +request.getRequestURI().toString());
//        UnifyResponse<> response =
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
        return  r;
    }

    private String formatErrorsMessage(List<ObjectError> errors){
        StringBuffer message = new StringBuffer();
        errors.forEach(error ->
                    message.append(error.getDefaultMessage()).append(";")
                );
        return message.toString();
    }


}
