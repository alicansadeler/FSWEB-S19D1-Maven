package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<ApiErrorResponse> exceptionHandler(PlantException apiException) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(apiException.getMessage());
        return new ResponseEntity<>(apiErrorResponse, apiException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> exceptionHandler(Exception e) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(e.getMessage());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
