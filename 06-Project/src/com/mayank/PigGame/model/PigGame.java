package com.mayank.PigGame.model;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PigGame {
	private int totalScore = 0;
	private int turn = 1;
	private Random random = new Random();

	public void play(Scanner scanner) {
		System.out.println("Let's Play PIG!\n");
		System.out.println("* See how many turns it takes you to get to 20.");
		System.out.println("* Turn ends when you hold or roll a 1.");
		System.out.println("* If you roll a 1, you lose all points for the turn.");
		System.out.println("* If you hold, you save all points for the turn.\n");

		while (totalScore < 20) {
			System.out.println("TURN " + turn);
			int turnScore = 0;
			boolean turnOver = false;
			while (!turnOver) {
				try {
					System.out.print("Roll or Hold? (r/h): ");
					char choice = scanner.next().charAt(0);
					validateChoice(choice);
					switch (choice) {

					case 'r':
					case 'R':
						int die = random.nextInt(6) + 1;
						System.out.println("Die: " + die);

						if (die == 1) {
							System.out.println("Turn over. No score.\n");
							turnScore = 0;
							turnOver = true;
						} else {
							turnScore += die;
							System.out.println("Turn score: " + turnScore);
						}
						break;

					case 'h':
					case 'H':
						totalScore += turnScore;
						System.out.println("Score for turn: " + turnScore);
						System.out.println("Total score: " + totalScore + "\n");
						turnOver = true;
						break;
					}

				} catch (InvalidChoiceException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println("Invalid input!");
					scanner.next();
				}
			}
			turn++;
		}

		System.out.println("You finished in " + (turn - 1) + " turns!");
		System.out.println("Game Over!");
	}

	private void validateChoice(char choice) throws InvalidChoiceException {
		if (choice != 'r' && choice != 'R' && choice != 'h' && choice != 'H') {
			throw new InvalidChoiceException("Please enter only r or h.");
		}
	}
}
