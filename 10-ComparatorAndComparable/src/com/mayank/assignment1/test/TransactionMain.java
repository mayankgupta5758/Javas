package com.mayank.assignment1.test;

import java.util.*;

import com.mayank.assignment1.model.*;

public class TransactionMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Transaction> list = new ArrayList<>();

		int n = 0;

		while (true) {
			try {
				System.out.print("Enter number of transactions: ");
				n = sc.nextInt();

				if (n <= 0) {
					System.out.println("Number must be greater than 0.");
					continue;
				}

				break;

			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter integer only.");
				sc.next();
			}
		}

		for (int i = 0; i < n; i++) {

			int id = 0;
			double amount = 0;

			while (true) {
				try {
					System.out.print("Enter Transaction ID: ");
					id = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid ID. Enter integer only.");
					sc.next();
				}
			}

			while (true) {
				try {
					System.out.print("Enter Amount: ");
					amount = sc.nextDouble();

					if (amount < 0) {
						System.out.println("Amount cannot be negative.");
						continue;
					}

					break;

				} catch (InputMismatchException e) {
					System.out.println("Invalid amount. Enter number only.");
					sc.next();
				}
			}

			list.add(new Transaction(id, amount));
		}

		Collections.sort(list, new TransactionComparator());

		System.out.println("\nSorted Transactions:");

		for (Transaction t : list) {
			System.out.println(t.id + " " + t.amount);
		}

		sc.close();
	}
}
