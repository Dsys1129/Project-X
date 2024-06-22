package com.duodome11.global.exception.custom;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends CustomException {

    public UserAlreadyExistException(String message) {
        super(message);
        this.code = "UserAlreadyExist";
        this.message = message;
        this.httpStatus = HttpStatus.CONFLICT.value();
    }
}
