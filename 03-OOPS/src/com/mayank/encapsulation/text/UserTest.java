package com.mayank.encapsulation.text;


import java.util.Scanner;

import com.mayank.encapsulation.model.User;


public class UserTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		user.userName();
		System.out.println("Deposite/Withdraw/Check press 1 for exit 0.");
		while (true) {
			int num = scanner.nextInt();
			if (num == 1) {
				user.performSomeAction();
			} else if (num == 0) {
				System.out.println("Exiting...");
				break;
			} else {
				System.out.println("Enter 1 or 0.");
			}
		}
		scanner.close();
	}

}
