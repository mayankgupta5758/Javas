package com.mayank.inheritance.test;

import java.util.Scanner;
import com.mayank.inheritance.model.*;

public class BankApp {

	public static boolean validateName(String name) {
		return name != null && name.matches("^[A-Za-z ]+$");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Account savings = null;
		Account current = null;
		Account activeAccount = null;
		int accNumber = 1000;

		while (true) {

			System.out.println("\n===== BANK MENU =====");
			System.out.println("1. Create Savings Account");
			System.out.println("2. Create Current Account");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Check Balance");
//			System.out.println("6. Switch Account");
			System.out.println("7. Display Account Details");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				String sName;
				while (true) {
					System.out.print("Enter Name: ");
					sName = sc.nextLine();
					if (validateName(sName))
						break;
					System.out.println("Invalid Name! Only alphabets allowed.");
				}

				System.out.print("Enter Initial Balance: ");
				double sBal = sc.nextDouble();

				savings = new SavingsAccount(++accNumber, sName, sBal, 1000);

				activeAccount = savings;

				System.out.println("Savings Account Created & Activated!");
				break;

			case 2:
				String cName;
				while (true) {
					System.out.print("Enter Name: ");
					cName = sc.nextLine();
					if (validateName(cName))
						break;
					System.out.println("Invalid Name! Only alphabets allowed.");
				}

				System.out.print("Enter Initial Balance: ");
				double cBal = sc.nextDouble();

				current = new CurrentAccount(++accNumber, cName, cBal, 5000);

				activeAccount = current;

				System.out.println("Current Account Created & Activated!");
				break;

			case 3:
				if (activeAccount == null) {
					System.out.println("No Active Account!");
					break;
				}

				System.out.print("Enter Deposit Amount: ");
				double dep = sc.nextDouble();
				System.out.println(activeAccount.deposit(dep));
				break;

			case 4:
				if (activeAccount == null) {
					System.out.println("No Active Account!");
					break;
				}

				System.out.print("Enter Withdrawal Amount: ");
				double wit = sc.nextDouble();
				System.out.println(activeAccount.withdraw(wit));
				break;

			case 5:
				if (activeAccount == null) {
					System.out.println("No Active Account!");
					break;
				}
				System.out.println(activeAccount.checkBalance());
				break;

//			case 6:
////				if (savings != null && current != null) {
////					System.out.println("No accounts created yet!");
////					break;
////				}
//
//				System.out.println("Press 2 for Savings");
//				System.out.println("Press 1 for Current");
//				int sw = sc.nextInt();
//
//				if (sw == 1 && current == null) {
//					activeAccount = savings;
//					savings = null;
//					System.out.println("Switched to Current Account.");
//				} else if (sw == 2 && current == null) {
//					activeAccount = current;
//					current = null;
//					System.out.println("Switched to Saving Account.");
//				} else {
//					System.out.println("Account not available.");
//				}
//				break;

			case 7:
				if (activeAccount == null) {
					System.out.println("No Active Account!");
					break;
				}
				activeAccount.displayDetails();
				break;

			case 0:
				System.out.println("Thank you for using Bank App!");
				sc.close();
				return;

			default:
				System.out.println("Invalid Choice!");
			}
		}
	}
}