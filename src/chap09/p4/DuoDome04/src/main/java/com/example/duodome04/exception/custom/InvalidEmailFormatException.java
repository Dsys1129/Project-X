package com.example.duodome04.exception.custom;

import org.springframework.http.HttpStatus;

public class InvalidEmailFormatException extends CustomException {

    public InvalidEmailFormatException(String message) {
        super(message);
        this.code = "InvalidEmailFormat";
        this.message = message;
        this.httpStatus = HttpStatus.BAD_REQUEST.value();
    }
}
