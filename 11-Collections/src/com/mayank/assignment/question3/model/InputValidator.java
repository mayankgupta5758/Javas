package com.mayank.assignment.question3.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

	public static int getValidInt(Scanner sc, String msg) {
		int value = -1;
		while (true) {
			try {
				System.out.print(msg);
				value = sc.nextInt();
				sc.nextLine();
				if (value > 0)
					return value;
				else
					System.out.println("Enter positive number.");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Enter numbers only.");
				sc.nextLine();
			}
		}
	}

	public static String getValidString(Scanner sc, String msg) {
		String value = "";
		while (true) {
			System.out.print(msg);
			value = sc.nextLine();

			if (value.matches("[a-zA-Z ]+") && value.trim().length() >= 2) {
				return value.trim();
			} else {
				System.out.println("Invalid input! Use alphabets only.");
			}
		}
	}

	public static double getValidDouble(Scanner sc, String msg) {
		while (true) {
			System.out.print(msg);
			if (sc.hasNextDouble()) {
				return sc.nextDouble();
			} else {
				System.out.println("Invalid number. Try again.");
				sc.next();
			}
		}
	}
}