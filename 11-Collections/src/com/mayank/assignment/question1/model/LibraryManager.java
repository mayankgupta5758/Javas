package com.mayank.assignment.question1.model;

import java.util.*;

public class LibraryManager {

	private Set<Book> books = new HashSet<>();
	private Queue<Integer> issueQueue = new LinkedList<>();

	public void addBook(Book book) {
		if (books.add(book)) {
			System.out.println("Book added successfully");
		} else {
			System.out.println("Duplicate book! Not added");
		}
	}

	public void displayBooks() {
		if (books.isEmpty()) {
			System.out.println("No books available");
			return;
		}
		books.forEach(System.out::println);
	}

	public void displaySortedByTitle() {
		books.stream().sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println);
	}

	public void displaySortedById() {
		books.stream().sorted(Comparator.comparing(Book::getBookId)).forEach(System.out::println);
	}

	public boolean findById(int id) {
		for (Book book : books) {
			if (book.bookId == id) {
				return true;
			}
		}
		return false;
	}

	public void requestIssue(int bookId) {
		if (findById(bookId)) {
			issueQueue.offer(bookId);
			System.out.println("Request added to queue");
			return;
		}
		System.out.println("Book Not Found!!!");
	}

	public void processIssue() {
		if (issueQueue.isEmpty()) {
			System.out.println("No pending requests");
			return;
		}

		int id = issueQueue.poll();

		for (Book b : books) {
			if (b.getBookId() == id) {
				if (b.getStatus() == BookStatus.AVAILABLE) {
					b.setStatus(BookStatus.ISSUED);
					System.out.println("Book issued: " + b.getTitle());
				} else {
					System.out.println("Book already issued");
				}
				return;
			}
		}

		System.out.println("Book not found");
	}

	public void removeBook(int id) {
		boolean removed = books.removeIf(b -> b.getBookId() == id);
		if (removed)
			System.out.println("Book removed");
		else
			System.out.println("Book not found");
	}

	public void searchByTitle(String title) {
		books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).forEach(System.out::println);
	}

	public void showAvailableBooks() {
		books.stream().filter(b -> b.getStatus() == BookStatus.AVAILABLE).forEach(System.out::println);
	}
}