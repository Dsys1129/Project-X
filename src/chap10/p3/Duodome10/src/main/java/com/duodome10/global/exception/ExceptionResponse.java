package com.duodome10.global.exception;


import com.duodome10.global.exception.custom.CustomException;
import lombok.Getter;

@Getter
public class ExceptionResponse {
    private String code;
    private String message;
    private int httpStatus;

    public ExceptionResponse(CustomException customException) {
        this.code = customException.getCode();
        this.message = customException.getMessage();
        this.httpStatus = customException.getHttpStatus();
    }
}
