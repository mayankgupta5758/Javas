package com.mayank.sudokuvalidator.model;

import java.util.Scanner;

public class UtilityFunction {
	
	public static int getIntInput(Scanner sc, String msg) {
		while (true) {
			System.out.print(msg);
			if (sc.hasNextInt()) {
				return sc.nextInt();
			} else {
				System.out.println("Invalid number. Try again.");
				sc.next();
			}
		}
	}

	public static void printGrid(int[][] grid) {
		System.out.print("    ");
		for (int i = 0; i < 9; i++) {
			System.out.print(i + " ");
			if (i == 2 || i == 5)
				System.out.print("| ");
		}
		System.out.println();
		System.out.println("  -----------------------");
		for (int i = 0; i < 9; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0)
					System.out.print("_ ");
				else
					System.out.print(grid[i][j] + " ");

				if (j == 2 || j == 5)
					System.out.print("| ");
			}
			System.out.println();
			if (i == 2 || i == 5)
				System.out.println("  -----------------------");
		}
	}

	public static boolean countEmptyPosition(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
}