package com.mayank.sudokuvalidator.model;

public abstract class SudokuValidate {
	abstract boolean validate(int[][] grid, int row, int col, int num);
}