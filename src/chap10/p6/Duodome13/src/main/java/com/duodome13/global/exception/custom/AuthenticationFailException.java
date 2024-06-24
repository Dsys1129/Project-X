package com.duodome13.global.exception.custom;

import org.springframework.http.HttpStatus;

public class AuthenticationFailException extends CustomException {

    private String code;
    private String message;
    private int httpStatus;

    public AuthenticationFailException(String message) {
        super(message);
        this.code = "AuthentciationFail";
        this.message = message;
        this.httpStatus = HttpStatus.UNAUTHORIZED.value();
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
