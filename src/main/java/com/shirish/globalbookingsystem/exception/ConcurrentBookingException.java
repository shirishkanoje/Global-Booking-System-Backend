package com.shirish.globalbookingsystem.exception;

public class ConcurrentBookingException extends RuntimeException {

    public ConcurrentBookingException(String message) {
        super(message);
    }
}