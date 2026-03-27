package com.mayank.NumberGuesser.test;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.mayank.NumberGuesser.model.NumberGuesserGame;

public class GameApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			try {
				System.out.println("\n1. Play Game");
				System.out.println("2. Exit");
				System.out.print("Enter choice: ");

				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					NumberGuesserGame game = new NumberGuesserGame();
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
				System.out.println("Enter Integer Only!!!");
				scanner.next();
			} catch (Exception e) {
				System.out.println("Some Exception Occur: " + e);
			}
		}

		scanner.close();
	}
}