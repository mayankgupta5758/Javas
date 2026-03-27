package com.mayank.assignment.question7.model;

class ParticipantNotFoundException extends Exception {
    public ParticipantNotFoundException(String msg) {
        super(msg);
    }
}

class EmptyDataException extends Exception {
    public EmptyDataException(String msg) {
        super(msg);
    }
}