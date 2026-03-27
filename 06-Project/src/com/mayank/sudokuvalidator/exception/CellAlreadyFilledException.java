package com.mayank.sudokuvalidator.exception;

public class CellAlreadyFilledException extends Exception {
    public CellAlreadyFilledException(String message) {
        super(message);
    }
}