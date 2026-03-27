package com.mayank.constructor.test;

import java.util.Scanner;
import com.mayank.constructor.model.BankAccount;
import com.mayank.constructor.model.PremiumAccount;

public class BankAccountTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your Account Name: ");
		String name = scanner.nextLine();

		System.out.println("Enter your Initial Bank Balance: ");
		double balance = scanner.nextDouble();
		double bal;
		
		if (balance <= 0) {
			bal = 0;
			System.out.println("Invalid initial balance. Set to 0.");
		} else {
			bal = balance;
		}

		BankAccount account = null;

		System.out.println("For Premium Account press 1 or for Normal Account press 2.");

		boolean chk = true;

		while (chk) {
			int choice = scanner.nextInt();
			if (choice == 1) {
				account = new PremiumAccount(name, bal + 1000);
				System.out.println("Premium Account Created Successfully.");
				chk = false;
			} else if (choice == 2) {
				account = new BankAccount(name, bal);
				System.out.println("Normal Account Created Successfully.");
				chk = false;
			} else {
				System.out.println("Invalid Choice. Enter 1 or 2.");
			}
		}

		while (true) {
			System.out.println("\nDeposit press 1, Check Balance press 2, Exit press 0");
			int num = scanner.nextInt();

			if (num == 1) {
				System.out.println("Enter amount to deposit: ");
				double amount = scanner.nextDouble();
				account.deposit(amount);
			} else if (num == 2) {
				System.out.println("Your Balance: " + account.getBalance());
			} else if (num == 0) {
				System.out.println("Exiting...");
				break;
			} else {
				System.out.println("Invalid option.");
			}
		}

		scanner.close();
	}
}
