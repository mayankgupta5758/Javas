package com.mayank.assignment.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.mayank.assignment.model.*;

public class BankAccountTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BankAccount account = null;

		BankAccount[] accountArray = new BankAccount[10];
		int i = 0;

		while (true) {

			try {

				System.out.println("\nSelect Account Type");
				System.out.println("1. Savings Account");
				System.out.println("2. Current Account");
				System.out.println("3. See All Accounts");
				System.out.println("4. Exit");

				System.out.print("Enter choice: ");
				int choice = sc.nextInt();
				sc.nextLine();

				if (choice == 4) {
					System.out.println("Thank you for banking with us.");
					break;
				}

				double balance = 0;
				String name = "";

				switch (choice) {

				case 1:
					boolean chk = true;

					while (chk) {

					    System.out.print("Enter Name: ");
					    name = sc.nextLine();

					    if (name.matches("[a-zA-Z ]+") && name.trim().length() >= 2) {
					        chk = false; 
					    } else {
					        System.out.println("Invalid name! Use alphabets only (min 2 chars).");
					    }
					}
					System.out.print("Enter Initial Balance: ");
					balance = sc.nextDouble();

					account = new SavingsAccount(name, balance);
					accountArray[i++] = account;

					break;

				case 2:
					chk = true;

					while (chk) {

					    System.out.print("Enter Name: ");
					    name = sc.nextLine();

					    if (name.matches("[a-zA-Z ]+") && name.trim().length() >= 2) {
					        chk = false; 
					    } else {
					        System.out.println("Invalid name! Use alphabets only (min 2 chars).");
					    }
					}

					System.out.print("Enter Initial Balance: ");
					balance = sc.nextDouble();

					account = new CurrentAccount(name, balance);
					accountArray[i++] = account;

					break;

				case 3:

					System.out.println("\n--- All Accounts ---");

					for (int j = 0; j < i; j++) {

						System.out.println("Account Holder Name: " + name);
						System.out.println("Balance: " + accountArray[j].getBalance());
						System.out.println("----------------------");
					}

					continue;

				default:
					System.out.println("Invalid choice.");
					continue;
				}

				while (true) {

					System.out.println("\n--- Account Menu ---");
					System.out.println("1. Deposit");
					System.out.println("2. Withdraw");
					System.out.println("3. Check Balance");
					System.out.println("4. Back");

					System.out.print("Enter option: ");
					int option = sc.nextInt();

					if (option == 4)
						break;

					switch (option) {

					case 1:

						System.out.print("Enter deposit amount: ");
						double dep = sc.nextDouble();

						account.deposit(dep);
						break;

					case 2:

						System.out.print("Enter withdraw amount: ");
						double wd = sc.nextDouble();

						account.withdraw(wd);
						break;

					case 3:

						account.checkBalance();
						break;

					default:
						System.out.println("Invalid option.");
					}
				}

			} catch (InputMismatchException e) {

				System.out.println("Invalid input! Please enter numbers only.");
				sc.nextLine();

			} catch (InvalidAmountException e) {

				System.out.println(e.getMessage());
			}
		}

		sc.close();
	}
}