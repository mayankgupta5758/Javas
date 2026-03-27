package com.mayank.interfaces.test;

import java.util.Scanner;
import com.mayank.interfaces.model.*;

public class ECommerceApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("E-Commerce Checkout");

		while (true) {

			System.out.println("\n1. Credit Card");
			System.out.println("2. UPI");
			System.out.println("3. Net Banking");
			System.out.println("4. Exit");

			System.out.print("Choose Payment Method: ");
			int choice = sc.nextInt();

			if (choice == 4) {
				System.out.println("Thank you for using the system");
				break;
			}

			PaymentGateway gateway = null;

			switch (choice) {
			case 1:
				gateway = new CreditCard();
				break;
			case 2:
				gateway = new UPI();
				break;
			case 3:
				gateway = new NetBanking();
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
				continue; 
			}

			Checkout checkout = new Checkout(gateway);

			int type;
			while (true) {
				System.out.println("1. Pay");
				System.out.println("2. Refund");
				System.out.print("Choose transaction type: ");
				type = sc.nextInt();

				if (type == 1 || type == 2) {
					break; 
				} else {
					System.out.println("Invalid transaction type! Try again.");
				}
			}

			double amount;
			while (true) {
				System.out.print("Enter amount: ");
				amount = sc.nextDouble();

				if (amount > 0) {
					break;
				} else {
					System.out.println("Amount must be positive! Try again.");
				}
			}

			if (type == 1) {
				checkout.processPayment(amount);
			} else {
				checkout.processRefund(amount);
			}
		}

		sc.close();
	}
}