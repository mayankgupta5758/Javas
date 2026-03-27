package com.mayank.sudokuvalidator.model;

public class RowValidate extends SudokuValidate {

	@Override
	public boolean validate(int[][] grid, int row, int col, int num) {
		for (int j = 0; j < 9; j++) {
			if (grid[row][j] == num) {
				return false;
			}
		}
		return true;
	}
}