package com.mayank.tictactoe.exception;

public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(String message) {
        super(message);
    }
}