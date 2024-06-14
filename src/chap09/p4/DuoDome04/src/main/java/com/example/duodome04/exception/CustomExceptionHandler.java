package com.example.duodome04.exception;

import com.example.duodome04.exception.custom.CustomException;
import com.example.duodome04.exception.custom.InvalidEmailFormatException;
import com.example.duodome04.exception.custom.UserAlreadyExistException;
import com.example.duodome04.exception.custom.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptioResponse> handleException(CustomException e) {
        ExceptionResponse response = new ExceptionResponse(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomException> handleException(Exception e) {
        CustomException response = new CustomException("server Error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
