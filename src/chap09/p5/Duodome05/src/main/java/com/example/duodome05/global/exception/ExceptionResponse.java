package com.example.duodome05.global.exception;

import com.example.duodome05.global.exception.custom.CustomException;

public class ExceptionResponse {
    private String code;
    private String message;
    private int httpStatus;

    public ExceptionResponse(CustomException customException) {
        this.code = customException.getCode();
        this.message = customException.getMessage();
        this.httpStatus = customException.getHttpStatus();
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
