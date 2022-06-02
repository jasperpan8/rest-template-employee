package com.example.employeeresttemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("something happened", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
