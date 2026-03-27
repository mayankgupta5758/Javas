package com.mayank.assignment2.test;

import java.util.Scanner;
import com.mayank.assignment2.model.*;

public class LoanApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Loan[] loans = new Loan[10];
		int count = 0;

		while (true) {
			System.out.println("\n------ Loan System ------");
			System.out.println("1 Add Home Loan");
			System.out.println("2 Add Car Loan");
			System.out.println("3 Add Education Loan");
			System.out.println("4 Display Loans");
			System.out.println("5 Calculate Repayment");
			System.out.println("6 Exit");
			try {
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
				    count = UtilityFunction1.addHomeLoan(sc, loans, count);
					break;

				case 2:
					count = UtilityFunction1.addCarLoan(sc, loans, count);
					break;

				case 3:
					count = UtilityFunction1.addEducationLoan(sc, loans, count);
					break;

				case 4:
					UtilityFunction1.displayLoans(count, loans);
					break;

				case 5:
					UtilityFunction1.calculateRepaymentMethod(sc, count, loans);
					break;

				case 6:
					System.out.println("Exiting...");
					System.exit(0);

				default:
					System.out.println("Invalid Choice");

				}

			} catch (InvalidLoanException e) {
				System.out.println("Error : " + e.getMessage());
				sc.next();

			} catch (Exception e) {
				System.out.println("Invalid Input");
				sc.next();
			}

		}

	}

}