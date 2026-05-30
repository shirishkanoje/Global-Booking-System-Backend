package com.shirish.globalbookingsystem.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private Instant timestamp;

    private int status;

    private String error;
}