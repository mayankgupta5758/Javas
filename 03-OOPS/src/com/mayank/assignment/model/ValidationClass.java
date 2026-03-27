package com.mayank.assignment.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationClass {

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
				return value;
			} else {
				System.out.println("Invalid input! Use alphabets only.");
			}
		}
	}

	public static Status getValidateStatus(Scanner sc, String msg) {
		boolean chk = true;
		Status status = null;
		while (chk) {
			try {
				System.out.println("If you are FREE press 1.");
				System.out.println("If you are BUSY press 2.");
				int s = sc.nextInt();
				if (s == 1) {
					status = Status.FREE;
					chk = false;
				} else if (s == 2) {
					status = Status.BUSY;
					chk = false;
				} else {
					System.out.println("Enter 1 or 2.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter 1 or 2 only.");
				sc.next();
			}
		}
		return status;
	}
}
