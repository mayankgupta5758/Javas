package com.mayank.assignment;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String message) {
		super(message);
	}
}

public class CustomException {
	public static void checkPassword(String pwd) throws InvalidPasswordException {

		Pattern pattern = Pattern.compile("^(?=.*\\d).{8,}$");
		Matcher matcher = pattern.matcher(pwd);
		boolean result = matcher.matches();
		if (!result) {
			throw new InvalidPasswordException(
					"Password must be at least 8 characters and contain at least one digit.");
		}

		System.out.println("Password Correct.");
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter Password: ");
			String pass = scanner.nextLine();
			checkPassword(pass);
		} catch (InvalidPasswordException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
