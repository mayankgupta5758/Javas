package com.mayank.sudokuvalidator.test;

import java.util.Scanner;
import com.mayank.sudokuvalidator.model.*;

public class SudokuApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello User.");

		boolean chk = true;
		System.out.println("For Play press 1.");
		System.out.println("For Exit press 2.");
		while (chk) {
			int key = UtilityFunction.getIntInput(scanner, "Enter 1 or 2: ");
			switch (key) {

			case 1:
				SudokuGrid grid = new SudokuGrid();
				grid.playGame(scanner);
				break;

			case 2:
				System.out.println("Exiting...");
				chk = false;
				break;

			default:
				System.out.println("Enter 1 or 2 Only.");
			}
		}

		scanner.close();
	}
}