package com.mayank.NumberGuesser.model;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGuesserGame {
	private int randomNumber;
	private int maxAttempts = 5;
	private int attempts = 0;

	public NumberGuesserGame() {
		Random random = new Random();
		randomNumber = random.nextInt(100) + 1;
		System.out.println("Random number generated between 1 to 100");
	}

	public void play(Scanner scanner) {
		boolean guessed = false;
		while (attempts < maxAttempts) {
			System.out.println("Chances left: " + (maxAttempts - attempts));
			try {
				System.out.print("Enter your guess: ");
				int guess = scanner.nextInt();
				validateGuess(guess);
				attempts++;
				if (guess < randomNumber) {
					System.out.println("Too Low");
				} else if (guess > randomNumber) {
					System.out.println("Too High");
				} else {
					System.out.println("You won in attempt: " + attempts);
					guessed = true;
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter only integer!");
				scanner.next();
			} catch (InvalidGuessException e) {
				System.out.println(e.getMessage());
			}
		}

		if (!guessed) {
			System.out.println("You lost! Correct number was: " + randomNumber);
		}
	}

	private void validateGuess(int guess) throws InvalidGuessException {
		if (guess < 1 || guess > 100) {
			throw new InvalidGuessException("Number must be between 1 and 100");
		}
	}
}