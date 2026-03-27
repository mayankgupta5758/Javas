package com.mayank.sudokuvalidator.model;

public class ColumnValidate extends SudokuValidate {

	@Override
	public boolean validate(int[][] grid, int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == num) {
				return false;
			}
		}

		return true;
	}
}