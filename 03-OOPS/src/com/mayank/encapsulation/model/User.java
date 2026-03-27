package com.mayank.encapsulation.model;


import java.util.Scanner;

public class User {
	Scanner scanner = new Scanner(System.in);
	BankAccount bankAccount = new BankAccount();

	public void userName() {
		System.out.println("Enter the Account Holder Name: ");
		bankAccount.setAccountHolderName(scanner.nextLine());
	}

	public void performSomeAction() {
		boolean doSomething = true;

		while (doSomething) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("For check Balance press 1.");
			System.out.println("For add Money press 2.");
			System.out.println("For withdraw Money press 3.");
			System.out.println("For Exit press 0.");
			int num = scanner.nextInt();

			switch (num) {

			case 1:
				bankAccount.checkBalance();
				break;

			case 2:
				System.out.println("Enter the amount to add.");
				int amount1 = scanner.nextInt();
				bankAccount.depositeMoney(amount1);
				break;
			case 3:
				System.out.println("Enter the amount to withdraw.");
				int amount2 = scanner.nextInt();
				bankAccount.withdrawMoney(amount2);
				break;
			case 0:
				System.out.println("Exiting...");
				doSomething = false;
				break;
			default:
				System.out.println("Enter 0, 1, 2 or 3.");
				break;
			}

		}
	}
}
