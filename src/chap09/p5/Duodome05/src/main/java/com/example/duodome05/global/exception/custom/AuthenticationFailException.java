package com.example.duodome05.global.exception.custom;

import org.springframework.http.HttpStatus;

public class AuthenticationFailException extends CustomException {
    public AuthenticationFailException(String message) {
        super(message);
        this.code = "AuthentciationFail";
        this.message = message;
        this.httpStatus = HttpStatus.UNAUTHORIZED.value();
    }
}
