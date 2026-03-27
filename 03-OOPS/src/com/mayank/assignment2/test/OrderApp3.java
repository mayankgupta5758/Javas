package com.mayank.assignment2.test;

import java.util.Scanner;
import com.mayank.assignment2.model.*;

public class OrderApp3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Order3[] orders = new Order3[10];
		int count = 0;

		boolean run = true;
		while (run) {
			System.out.println("\n===== ORDER MENU =====");
			System.out.println("1 Add Standard Order");
			System.out.println("2 Add Express Order");
			System.out.println("3 Add International Order");
			System.out.println("4 Display Orders");
			System.out.println("5 Process Orders");
			System.out.println("6 Exit");

			int choice = InputValidator3.getValidInt(sc, "Enter choice: ");
			try {
				switch (choice) {
				case 1:
					int id = InputValidator3.getValidInt(sc, "Enter Order ID: ");
					String name = InputValidator3.getValidName(sc, "Enter Customer Name: ");
					double amount = InputValidator3.getValidDouble(sc, "Enter Amount: ");
					orders[count++] = new StandardOrder3(id, name, amount);
					break;

				case 2:
					id = InputValidator3.getValidInt(sc, "Enter Order ID: ");
					name = InputValidator3.getValidName(sc, "Enter Customer Name: ");
					amount = InputValidator3.getValidDouble(sc, "Enter Amount: ");
					orders[count++] = new ExpressOrder3(id, name, amount);
					break;

				case 3:
					id = InputValidator3.getValidInt(sc, "Enter Order ID: ");
					name = InputValidator3.getValidName(sc, "Enter Customer Name: ");
					amount = InputValidator3.getValidDouble(sc, "Enter Amount: ");
					orders[count++] = new InternationalOrder3(id, name, amount);
					break;

				case 4:
					for (int i = 0; i < count; i++)
						orders[i].display();
					break;

				case 5:
					for (int i = 0; i < count; i++) {
						if (orders[i].verifyOrder())
							orders[i].processOrder();
						else
							System.out.println("Order verification failed for ID: " + orders[i].orderId);
					}
					break;

				case 6:
					run = false;
					System.out.println("System Closed");
					break;

				default:
					System.out.println("Invalid Choice");
				}
			} catch (InvalidOrderException3 e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}