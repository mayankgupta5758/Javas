package com.mayank.assignment2.model;

public class InvalidLoanException extends Exception {
    public InvalidLoanException(String message) {
        super(message);
    }
}