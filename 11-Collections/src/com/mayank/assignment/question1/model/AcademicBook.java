package com.mayank.assignment.question1.model;

public class AcademicBook extends Book {

    private String subject;

    public AcademicBook(int bookId, String title, String author, String subject) {
        super(bookId, title, author);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " | Subject: " + subject;
    }
}