package com.bofa.circuitbreakerapi.exceptions;

public class IgnoreException extends RuntimeException {
    public IgnoreException(String message) {
        super(message);
    }
}
