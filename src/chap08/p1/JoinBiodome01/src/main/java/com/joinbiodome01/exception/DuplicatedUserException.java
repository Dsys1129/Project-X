package com.joinbiodome01.exception;

public class DuplicatedUserException extends RuntimeException{

    public DuplicatedUserException(String message) {
        super(message);
    }
}
