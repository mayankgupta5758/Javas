package com.mayank.assignment2.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilityFunction1 {
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

	public static double getValidDouble(Scanner sc, String msg) {
		double value = 0;
		while (true) {
			try {
				System.out.print(msg);
				value = sc.nextDouble();
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

	public static int getValidateInt(Scanner sc, String msg) {
		int value = 0;
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

	public static int addHomeLoan(Scanner sc, Loan[] loans, int count) throws Exception {
		double income = getValidDouble(sc, "Enter Monthly Income: ");
		int creditScore = getValidateInt(sc, "Enter Credit Score: ");

		HomeLoan tempLoan = new HomeLoan(0, "", 1, 1);

		if (!tempLoan.checkEligibility(income, creditScore)) {
			System.out.println("Customer is NOT eligible for Home Loan.");
			return count;
		}

		System.out.println("Customer Eligible. Enter Loan Details.");
		int id = getValidateInt(sc, "Enter Id: ");
		String name = getValidString(sc, "Enter Name: ");
		double amount = getValidDouble(sc, "Enter Principal Amount: ");
		double rate = getValidDouble(sc, "Enter Rate: ");

		loans[count] = new HomeLoan(id, name, amount, rate);
		System.out.println("Home Loan Added Successfully.");
		return count + 1;
	}

	public static int addCarLoan(Scanner sc, Loan[] loans, int count) throws Exception {
		double income = getValidDouble(sc, "Enter Monthly Income: ");
		int creditScore = getValidateInt(sc, "Enter Credit Score: ");
		CarLoan tempLoan = new CarLoan(0, "", 1, 1);

		if (!tempLoan.checkEligibility(income, creditScore)) {
			System.out.println("Customer is NOT eligible for Home Loan.");
			return count;
		}

		System.out.println("Customer Eligible. Enter Loan Details.");
		int id = getValidateInt(sc, "Enter Id: ");
		String name = getValidString(sc, "Enter Name: ");
		double amount = getValidDouble(sc, "Enter Principal Amount: ");
		double rate = getValidDouble(sc, "Enter Rate: ");

		loans[count] = new CarLoan(id, name, amount, rate);
		System.out.println("Home Loan Added Successfully.");
		return count + 1;
	}

	public static int addEducationLoan(Scanner sc, Loan[] loans, int count) throws Exception {
		double income = getValidDouble(sc, "Enter Monthly Income: ");
		int creditScore = getValidateInt(sc, "Enter Credit Score: ");
		EducationLoan tempLoan = new EducationLoan(0, "", 1, 1);

		if (!tempLoan.checkEligibility(income, creditScore)) {
			System.out.println("Customer is NOT eligible for Home Loan.");
			return count;
		}

		System.out.println("Customer Eligible. Enter Loan Details.");
		int id = getValidateInt(sc, "Enter Id: ");
		String name = getValidString(sc, "Enter Name: ");
		double amount = getValidDouble(sc, "Enter Principal Amount: ");

		loans[count] = new EducationLoan(id, name, amount, 0);
		System.out.println("Home Loan Added Successfully.");

		return count + 1;
	}

	public static void calculateRepaymentMethod(Scanner sc, int count, Loan[] loans) {
		if (count == 0) {
			System.out.println("No Loans Yet!!!");
			return;
		}
		int years = UtilityFunction1.getValidateInt(sc, "Enter Years: ");
		System.out.println("-------------------------");
		for (int i = 0; i < count; i++) {
			double repayment = loans[i].calculateRepayment(years);
			System.out.println("Loan ID " + loans[i].getLoanId() + " Repayment Amount: " + repayment);
		}
		System.out.println("-------------------------");
	}

	public static void displayLoans(int count, Loan[] loans) {
		if (count == 0) {
			System.out.println("No Loans Yet!!!");
			return;
		}
		for (int i = 0; i < count; i++) {
			loans[i].display();
		}
	}
}
