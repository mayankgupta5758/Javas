package com.mayank.assignment.question1.model;

public class Magazine extends Book {

    private int issueNumber;

    public Magazine(int bookId, String title, String author, int issueNumber) {
        super(bookId, title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " | Issue No: " + issueNumber;
    }
}