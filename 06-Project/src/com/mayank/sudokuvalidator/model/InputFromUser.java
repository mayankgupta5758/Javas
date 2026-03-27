package com.mayank.sudokuvalidator.model;

import java.util.Scanner;
import com.mayank.sudokuvalidator.exception.*;

public class InputFromUser {
	public static void takingInputFromUser(int[][] grid, Scanner scanner) {

		while (UtilityFunction.countEmptyPosition(grid)) {

			RowValidate rowV = new RowValidate();
			ColumnValidate colV = new ColumnValidate();
			BoxValidate boxV = new BoxValidate();

			try {
				int row = UtilityFunction.getIntInput(scanner, "Enter row (0-8): ");
				if (!(row >= 0 && row <= 8)) {
					throw new InvalidInputException("Row must be between 0 and 8");
				}

				int col = UtilityFunction.getIntInput(scanner, "Enter column (0-8): ");
				if (!(col >= 0 && col <= 8)) {
					throw new InvalidInputException("Column must be between 0 and 8");
				}

				int num = UtilityFunction.getIntInput(scanner, "Enter value (1-9): ");
				if (!(num >= 1 && num <= 9)) {
					throw new InvalidInputException("Number must be between 1 and 9");
				}

				if (!rowV.validate(grid, row, col, num) || !colV.validate(grid, row, col, num)
						|| !boxV.validate(grid, row, col, num)) {

					throw new InvalidMoveException("Sudoku rule break!");
				}

				if (grid[row][col] != 0) {
					throw new CellAlreadyFilledException("Cell already filled!");
				}

				grid[row][col] = num;
				System.out.println("Correct move.");
				UtilityFunction.printGrid(grid);

			} catch (InvalidInputException | InvalidMoveException | CellAlreadyFilledException e) {
				System.out.println("❌ " + e.getMessage());
			}
		}
	}
}