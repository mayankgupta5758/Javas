package com.mayank.assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowKeyword {

	public static void validateMarks(int marks) {
		if (marks < 0 || marks > 100) {
			throw new IllegalArgumentException("Marks should be in Between 1 to 100.");
		}
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter Marks in Between 1 to 100.");
			int marks = scanner.nextInt();
			validateMarks(marks);
			System.out.println("Valid Marks.");;
		} catch (InputMismatchException e) {
			System.out.println("Enter Integer only!!!");
		} catch (IllegalArgumentException e) {
			 System.out.println(e.getMessage());
		 }
	}
}
