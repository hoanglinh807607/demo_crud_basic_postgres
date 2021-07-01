package com.postgresql.connect_postgresql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import org.springframework.validation.BindException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorRespone handlerEmptyException(NotFoundException ex, WebRequest req) {
        return new ErrorRespone(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ErrorRespone handlerBindException(BindException ex, WebRequest req) {
        return new ErrorRespone(HttpStatus.PRECONDITION_FAILED, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
