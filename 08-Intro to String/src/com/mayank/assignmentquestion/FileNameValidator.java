package com.mayank.assignmentquestion;

import java.util.Scanner;

public class FileNameValidator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter FileName: ");
		String fileName = scanner.nextLine();

		boolean endWithpdf = fileName.endsWith(".pdf");
		int index = fileName.lastIndexOf(".");
		String newFileName = fileName.substring(0, index);
		String extension = fileName.substring(index + 1);
		newFileName = newFileName.replaceAll("_", " ");
		boolean checkFinal = fileName.contains("final");

		System.out.println("File Name: " + newFileName);
		System.out.println("Extension: " + extension);
		System.out.println("Is PDF file: " + (endWithpdf ? "Yes" : "No"));
		System.out.println("Contains 'final': " + (checkFinal ? "Yes" : "No"));
		scanner.close();
	}

}
