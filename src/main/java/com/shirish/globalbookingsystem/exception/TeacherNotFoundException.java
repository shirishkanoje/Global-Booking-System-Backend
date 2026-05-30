package com.shirish.globalbookingsystem.exception;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(String message) {
        super(message);
    }
}