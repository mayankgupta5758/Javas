package com.mayank.assignmentquestion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PasswordValidator {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Password: ");
			String password = sc.nextLine();

			password = password.replace(" ", "");
			boolean hasUpper = false;
			boolean hasLower = false;
			boolean hasDigit = false;
			boolean lengthValid = password.length() >= 8;

			for (int i = 0; i < password.length(); i++) {
				char ch = password.charAt(i);
				if (Character.isUpperCase(ch))
					hasUpper = true;
				if (Character.isLowerCase(ch))
					hasLower = true;
				if (Character.isDigit(ch))
					hasDigit = true;
			}

			System.out.println("Length valid: " + (lengthValid ? "Yes" : "No"));
			System.out.println("Contains uppercase: " + (hasUpper ? "Yes" : "No"));
			System.out.println("Contains lowercase: " + (hasLower ? "Yes" : "No"));
			System.out.println("Contains digit: " + (hasDigit ? "Yes" : "No"));

			if (lengthValid && hasUpper && hasLower && hasDigit) {
				System.out.println("Password is VALID");
			} else {
				System.out.println("Password is INVALID");
			}

		} catch (InputMismatchException e) {
			System.out.println("Enter String only.");
		} catch (Exception e) {
			System.out.println("Some Exception occur: " + e);
		}
	}
}