package com.lcwr.spring_validation.exception;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message ){
        super(message);
    }
}
