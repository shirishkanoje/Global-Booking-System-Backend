package com.shirish.globalbookingsystem.exception;

public class SessionOverlapException extends RuntimeException {

    public SessionOverlapException(String message) {
        super(message);
    }
}