package com.duodome13.global.exception;


import com.duodome13.global.exception.custom.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleException(CustomException e) {
        ExceptionResponse response = new ExceptionResponse(e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e, HttpServletRequest request) {
        logger.error("Error Request {} => Params: {} => Error: {}", request.getRequestURL(), request.getParameterMap(), e.getMessage(), e);
        CustomException customException = new CustomException("server Error");
        ExceptionResponse response = new ExceptionResponse(customException);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
