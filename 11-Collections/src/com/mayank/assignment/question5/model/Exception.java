package com.mayank.assignment.question5.model;

class PassengerNotFoundException extends Exception {
    public PassengerNotFoundException(String msg) {
        super(msg);
    }
}

class EmptyDataException extends Exception {
    public EmptyDataException(String msg) {
        super(msg);
    }
}