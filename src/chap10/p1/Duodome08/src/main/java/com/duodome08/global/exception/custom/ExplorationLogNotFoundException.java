package com.duodome08.global.exception.custom;

import org.springframework.http.HttpStatus;

public class ExplorationLogNotFoundException extends CustomException {
    public ExplorationLogNotFoundException(String message) {
        super(message);
        this.code = "ExplorationLogNotFound";
        this.message = message;
        this.httpStatus = HttpStatus.NOT_FOUND.value();
    }
}
