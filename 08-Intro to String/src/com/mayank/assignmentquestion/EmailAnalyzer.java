package com.mayank.assignmentquestion;

import java.util.*;

public class EmailAnalyzer {
	public static void main(String[] args) {
		System.out.println("Enter Email Address: ");
		try (Scanner scanner = new Scanner(System.in)) {
			String email = scanner.nextLine();
			String newEmail = email.trim();

			if (!newEmail.contains("@")) {
				System.out.println("Enter the proper email with '@'.");
				return;
			}

			int indexforUesrName = newEmail.indexOf('@');
			String userName = newEmail.substring(0, indexforUesrName);
			String domainName = newEmail.substring(indexforUesrName + 1);
//			String lowerCaseEmail = newEmail.toLowerCase();

			userName = userName.replace('.', '_');
			System.out.println("UserName: " + userName);
			System.out.println("Domain: " + domainName);
			System.out.println("Total characters in username: " + userName.length());
			System.out.println(domainName.equalsIgnoreCase("gmail.com") ? "Your domain name is gmail.com"
					: "Your domain name is not gmail.com.");
			System.out.println(userName.matches(".*[1-9].*") ? "Contains digits: Yes." : "Contains digits: No.");
			System.out.println("Modified username: " + userName);
		} catch (InputMismatchException e) {
			System.out.println("Enter String only.");
		} catch (Exception e) {
			System.out.println("Some Exception occur: " + e);
		}
	}

}
