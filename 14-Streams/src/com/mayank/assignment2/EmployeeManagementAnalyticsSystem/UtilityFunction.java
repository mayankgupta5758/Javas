package com.mayank.assignment2.EmployeeManagementAnalyticsSystem;
import java.util.*;

public class UtilityFunction {	
	public static int getValidInt(Scanner sc, String msg) {
		while (true) {
			try {
				System.out.print(msg);
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid number. Try again.");
			}
		}
	}

	static double getValidDouble(Scanner sc, String msg) {
		while (true) {
			try {
				System.out.print(msg);
				double val = Double.parseDouble(sc.nextLine());
				if (val < 0)
					throw new Exception();
				return val;
			} catch (Exception e) {
				System.out.println("Invalid salary. Try again.");
			}
		}
	}

	static String getValidString(Scanner sc, String msg) {
		while (true) {
			System.out.print(msg);
			String s = sc.nextLine().trim();
			if (!s.isEmpty())
				return s;
			System.out.println("Input cannot be empty.");
		}
	}

	static boolean getValidBoolean(Scanner sc, String msg) {
		while (true) {
			System.out.print(msg);
			String input = sc.nextLine().toLowerCase();
			if (input.equals("true") || input.equals("false")) {
				return Boolean.parseBoolean(input);
			}
			System.out.println("Enter true or false only.");
		}
	}
}
