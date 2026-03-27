package com.mayank.assignmentquestion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductCodeValidator {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.print("Enter product code: ");
			String code = sc.nextLine().trim();

			String[] parts = code.split("-");

			if (parts.length != 3) {
				System.out.println("Invalid product code format. Use CAT-ITEMCODE-YEAR");
				return;
			}

			String category = parts[0].toUpperCase();
			String product = parts[1];
			String year = parts[2];

			boolean startsWithTV = product.startsWith("TV");
			boolean endsWith2023 = code.endsWith("2023");
			String modifiedCode = code.replace("-", " ");
			int firstHyphen = code.indexOf('-');

			System.out.println("Category: " + category);
			System.out.println("Product: " + product);
			System.out.println("Year: " + year);
			System.out.println("Starts with TV: " + (startsWithTV ? "Yes" : "No"));
			System.out.println("Ends with 2023: " + (endsWith2023 ? "Yes" : "No"));
			System.out.println("Modified Code: " + modifiedCode);
			System.out.println("First hyphen position: " + firstHyphen);

		} catch (InputMismatchException e) {
			System.out.println("Enter String only.");
		} catch (Exception e) {
			System.out.println("Some Exception occur: " + e);
		}
	}
}