package com.example.duodome04.exception.custom;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends CustomException {

    public UserAlreadyExistException(String message) {
        super(message);
        this.code = "UserAlreadyExist";
        this.message = message;
        this.httpStatus = HttpStatus.CONFLICT.value();
    }
}
