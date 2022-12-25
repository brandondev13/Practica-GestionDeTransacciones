package com.example.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String errMsg) {
        super(errMsg);
    }
}
