package com.duodome10.global.exception.custom;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    public UserNotFoundException(String message) {
        super(message);
        this.code = "UserNotFound";
        this.message = message;
        this.httpStatus = HttpStatus.NOT_FOUND.value();
    }
}
