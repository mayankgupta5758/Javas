package com.mayank.PigGame.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.mayank.PigGame.model.PigGame;

public class PigGameApp {

	public static void main(String[] args) {
		boolean running = true;
		Scanner scanner = new Scanner(System.in);

		while (running) {
			try {
				System.out.println("\n1. Play Pig Game");
				System.out.println("2. Exit");
				System.out.print("Enter choice: ");

				int choice = scanner.nextInt();

				switch (choice) {

				case 1:
					PigGame game = new PigGame();
					game.play(scanner);
					break;

				case 2:
					System.out.println("Thanks for playing!");
					running = false;
					break;

				default:
					System.out.println("Invalid choice!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Enter Integer Value Only!!!");
				scanner.next();
			} catch (Exception e) {
				System.out.println("Some Exception Occur: " + e.getMessage());
			}
		}

		scanner.close();
	}
}