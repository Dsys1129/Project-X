package com.example.duodome05.global.exception;

import com.example.duodome05.global.exception.custom.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleException(CustomException e) {
        ExceptionResponse response = new ExceptionResponse(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        CustomException customException = new CustomException("server Error");
        ExceptionResponse response = new ExceptionResponse(customException);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
