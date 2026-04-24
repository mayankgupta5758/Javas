package com.mayank.jdbcassignment.util;

import java.util.Scanner;

public class InputValidation {
	public static int getValidInt(Scanner sc, String msg) {
	    while (true) {
	        System.out.print(msg);
	        if (sc.hasNextInt()) {
	            int value = sc.nextInt();
	            sc.nextLine();
	            return value;
	        } else {
	            System.out.println("Invalid number. Try again.");
	            sc.next();
	        }
	    }
	}

	public static double getValidDouble(Scanner sc, String msg) {
	    while (true) {
	        System.out.print(msg);
	        if (sc.hasNextDouble()) {
	            double value = sc.nextDouble();
	            sc.nextLine();
	            return value;
	        } else {
	            System.out.println("Invalid number. Try again.");
	            sc.next();
	        }
	    }
	}

	public static String getValidString(Scanner sc, String msg) {

	    while (true) {
	        System.out.print(msg);
	        String input = sc.nextLine().trim();

	        if (input.isEmpty()) {
	            System.out.println("Input cannot be empty!");
	            continue;
	        }

	        if (!input.matches("[a-zA-Z ]+")) {
	            System.out.println("Invalid name. Only letters allowed.");
	            continue;
	        }

	        return input.replaceAll("\\s+", " ");
	    }
	}
}
