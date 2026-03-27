package com.mayank.assignment2.model;

import java.util.Scanner;

public class InputValidator2 {

	public static int getValidInt(Scanner sc, String msg) {
		while (true) {
			System.out.print(msg);
			if (sc.hasNextInt()) {
				return sc.nextInt();
			} else {
				System.out.println("Invalid number!");
				sc.next();
			}
		}
	}

	public static double getValidDouble(Scanner sc, String msg) {
		while (true) {
			System.out.print(msg);
			if (sc.hasNextDouble()) {
				return sc.nextDouble();
			} else {
				System.out.println("Invalid amount!");
				sc.next();
			}
		}
	}

	public static String getValidName(Scanner sc, String msg) {
		while (true) {
			System.out.print(msg);
			String name = sc.next();
			if (name.matches("[a-zA-Z]+"))
				return name;
			else
				System.out.println("Invalid name! Only letters allowed.");
		}
	}
}
