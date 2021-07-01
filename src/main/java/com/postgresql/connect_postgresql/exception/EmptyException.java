package com.postgresql.connect_postgresql.exception;

public class EmptyException extends RuntimeException {
    public EmptyException(String message) {
        super(message);
    }
}
