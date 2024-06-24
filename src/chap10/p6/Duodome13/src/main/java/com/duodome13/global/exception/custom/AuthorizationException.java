package com.duodome13.global.exception.custom;

import org.springframework.http.HttpStatus;

public class AuthorizationException extends CustomException {

    public AuthorizationException(String message) {
        super(message);
        this.code = "AuthorizationFail";
        this.message = message;
        this.httpStatus = HttpStatus.FORBIDDEN.value();
    }
}
