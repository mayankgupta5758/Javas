package com.mayank.assignment.question2.test;

import java.util.Scanner;
import com.mayank.assignment.question2.model.*;
import com.mayank.assignment.question3.model.InputValidator;

public class OrderApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OrderManager om = new OrderManager();
		boolean run = true;

		while (run) {
			System.out.println("\n===== MENU =====");
			System.out.println("1 Add Regular Order");
			System.out.println("2 Add Priority Order");
			System.out.println("3 Display All");
			System.out.println("4 Display by Customer");
			System.out.println("5 Sort by ID");
			System.out.println("6 Sort by Amount");
			System.out.println("7 Add to Dispatch");
			System.out.println("8 Process Dispatch");
			System.out.println("9 Cancel Order");
			System.out.println("10 Exit");

			int ch = InputValidator.getValidInt(sc, "Enter choice: ");
			try {
				switch (ch) {

				case 1:
					int id = InputValidator.getValidInt(sc, "ID: ");
					String name = InputValidator.getValidString(sc, "Customer: ");
					double amt = InputValidator.getValidInt(sc, "Amount: ");
					String del = InputValidator.getValidString(sc, "Delivery: ");
					om.addOrder(new RegularOrder(id, name, amt, del));
					break;

				case 2:
					id = InputValidator.getValidInt(sc, "ID: ");
					name = InputValidator.getValidString(sc, "Customer: ");
					amt = InputValidator.getValidInt(sc, "Amount: ");
					String pr = InputValidator.getValidString(sc, "Priority: ");
					om.addOrder(new PriorityOrder(id, name, amt, pr));
					break;

				case 3:
					om.displayAll();
					break;

				case 4:
					name = InputValidator.getValidString(sc, "Customer: ");
					om.displayByCustomer(name);
					break;

				case 5:
					om.sortById();
					break;

				case 6:
					om.sortByAmount();
					break;

				case 7:
					id = InputValidator.getValidInt(sc, "Order ID: ");
					om.addToDispatch(id);
					break;

				case 8:
					om.processDispatch();
					break;

				case 9:
					id = InputValidator.getValidInt(sc, "Cancel ID: ");
					om.cancelOrder(id);
					break;

				case 10:
					run = false;
					System.out.println("Exiting...");
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}