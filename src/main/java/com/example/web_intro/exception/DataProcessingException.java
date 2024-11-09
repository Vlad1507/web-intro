package com.example.web_intro.exception;

public class DataProcessingException  extends RuntimeException {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
