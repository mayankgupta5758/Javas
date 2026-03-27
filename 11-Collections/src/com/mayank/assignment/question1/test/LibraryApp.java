package com.mayank.assignment.question1.test;

import java.util.Scanner;
import com.mayank.assignment.question1.model.*;

public class LibraryApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LibraryManager library = new LibraryManager();
		boolean running = true;

		while (running) {
			System.out.println("\n===== Library Menu =====");
			System.out.println("1 Add Academic Book");
			System.out.println("2 Add Magazine");
			System.out.println("3 Display Books");
			System.out.println("4 Display Sorted by Title");
			System.out.println("5 Display Sorted by ID");
			System.out.println("6 Issue Request");
			System.out.println("7 Process Issue");
			System.out.println("8 Remove Book");
			System.out.println("9 Search by Title");
			System.out.println("10 Show Available Books");
			System.out.println("11 Exit");

			int choice = InputValidator.getValidInt(sc, "Enter choice: ");
			switch (choice) {

			case 1:
				int id = InputValidator.getValidInt(sc, "Enter ID: ");
				String title = InputValidator.getValidString(sc, "Enter Title: ");
				String author = InputValidator.getValidString(sc, "Enter Author: ");
				String subject = InputValidator.getValidString(sc, "Enter Subject: ");
				library.addBook(new AcademicBook(id, title, author, subject));
				break;

			case 2:
				id = InputValidator.getValidInt(sc, "Enter ID: ");
				title = InputValidator.getValidString(sc, "Enter Title: ");
				author = InputValidator.getValidString(sc, "Enter Author: ");
				int issue = InputValidator.getValidInt(sc, "Enter Issue Number: ");
				library.addBook(new Magazine(id, title, author, issue));
				break;

			case 3:
				library.displayBooks();
				break;

			case 4:
				library.displaySortedByTitle();
				break;

			case 5:
				library.displaySortedById();
				break;

			case 6:
				id = InputValidator.getValidInt(sc, "Enter Book ID: ");
				library.requestIssue(id);
				break;

			case 7:
				library.processIssue();
				break;

			case 8:
				id = InputValidator.getValidInt(sc, "Enter ID to remove: ");
				library.removeBook(id);
				break;

			case 9:
				String search = InputValidator.getValidString(sc, "Enter title: ");
				library.searchByTitle(search);
				break;

			case 10:
				library.showAvailableBooks();
				break;

			case 11:
				running = false;
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}