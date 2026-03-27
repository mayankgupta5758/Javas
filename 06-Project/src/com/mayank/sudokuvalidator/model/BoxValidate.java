package com.mayank.sudokuvalidator.model;

public class BoxValidate extends SudokuValidate {

	@Override
	public boolean validate(int[][] grid, int row, int col, int num) {
		int startRow = row - row % 3;
		int startCol = col - col % 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (grid[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}
}