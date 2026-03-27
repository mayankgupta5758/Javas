package com.mayank.sudokuvalidator.model;

import java.util.*;

public class RandomGenerate {
	public static void removeElementFromGrid(int[][] grid, int fillNum) {
		Random random = new Random();
		int notFilled = 0;

		while (notFilled < fillNum) {
			int row = random.nextInt(9);
			int col = random.nextInt(9);
			if (grid[row][col] != 0) {
				grid[row][col] = 0;
				notFilled++;
			}
		}
	}

	public static boolean isSafe(int[][] board, int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num)
				return false;
			if (board[i][col] == num)
				return false;
		}
		int startRow = row - row % 3;
		int startCol = col - col % 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[startRow + i][startCol + j] == num)
					return false;
			}
		}
		return true;
	}

	public static boolean fillBoard(int[][] board) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (board[row][col] == 0) {
					List<Integer> numbers = new ArrayList<>();
					for (int i = 1; i <= 9; i++) {
						numbers.add(i);
					}
					Collections.shuffle(numbers);
					for (int num : numbers) {
						if (isSafe(board, row, col, num)) {
							board[row][col] = num;
							if (fillBoard(board))
								return true;
							board[row][col] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}