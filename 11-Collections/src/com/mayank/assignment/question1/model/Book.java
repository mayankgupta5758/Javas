package com.mayank.assignment.question1.model;

public abstract class Book {

	protected int bookId;
	protected String title;
	protected String author;
	protected BookStatus status;

	public Book(int bookId, String title, String author) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.status = BookStatus.AVAILABLE;
	}

	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return title;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book Id: " + bookId + " | " + "Book Title: " + title + " | " + "Author Id: " + author + " | "
				+ "Book Status: " + status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book b = (Book) obj;
		return this.bookId == b.bookId;
	}

	@Override
	public int hashCode() {
		return bookId;
	}
}