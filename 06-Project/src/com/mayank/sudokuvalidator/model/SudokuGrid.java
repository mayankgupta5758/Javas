package com.mayank.sudokuvalidator.model;

import java.util.Random;
import java.util.Scanner;

public class SudokuGrid {
	private int[][] grid;

	public SudokuGrid() {
		grid = new int[9][9];
	}

	public SudokuGrid(int[][] grid) {
		setGrid(grid);
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				this.grid[i][j] = grid[i][j];
	}
	
	public void function(Random random, Scanner scanner, int num) {
		grid = new int[9][9];
		System.out.println("Generated Sudoku:\n");
		RandomGenerate.fillBoard(grid);
		int fill1 = num + random.nextInt(11);
		RandomGenerate.removeElementFromGrid(grid, fill1);
		UtilityFunction.printGrid(grid);
		InputFromUser.takingInputFromUser(grid, scanner);
		System.out.println("You Won The Game!!!");
	}

	public void playGame(Scanner scanner) {
		Random random = new Random();
		boolean chk = true;
		while (chk) {
			System.out.println("Press 1 for Easy Level.");
			System.out.println("Press 2 for Medium Level.");
			System.out.println("Press 3 for Hard Level.");
			System.out.println("Press 4 for Exit.");

			int key = UtilityFunction.getIntInput(scanner, "Enter  1, 2, 3 or 4: ");
			switch (key) {

			case 1:
				function(random, scanner, 50);
				break;

			case 2:
				function(random, scanner, 40);
				break;

			case 3:
				function(random, scanner, 30);
				break;

			case 4:
				System.out.println("Exiting!!!");
				chk = false;
				break;

			default:
				System.out.println("Enter 1,2,3 or 4");
			}
		}
	}
}