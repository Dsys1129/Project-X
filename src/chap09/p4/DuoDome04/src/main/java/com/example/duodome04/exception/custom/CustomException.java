package com.example.duodome04.exception.custom;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    protected String code;
    protected String message;
    protected int httpStatus;

    public CustomException(String message) {
        this.code = "InternalServerError";
        this.message = message;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }
}
