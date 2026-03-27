package com.mayank.tictactoe.model;

import java.util.Scanner;

public class ComputerTurn {

	public static boolean computerTurn(char[][] board, Scanner scanner, int playerNumber) {

		System.out.println("Computer tern.");

		int countEmptyforPlayer = TicTacToe.countEmptyPosition(board, 0);

		if (countEmptyforPlayer == 0) {
			System.out.println("Tie! No One Wins the Game.");
			return false;
		}

		if (TicTacToe.checkTwoNear(board, 'O', 'O')) {
			// winning move placed
		}

		else if (TicTacToe.checkTwoNear(board, 'X', 'O')) {
			// blocking move placed
		}

		else {

			if (board[1][1] == ' ') {
				board[1][1] = 'O';
			}

			else {

				int[][] corners = { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 2, 2 } };
				boolean placed = false;

				for (int i = 0; i < corners.length; i++) {
					int r = corners[i][0];
					int c = corners[i][1];

					if (board[r][c] == ' ') {
						board[r][c] = 'O';
						placed = true;
						break;
					}
				}

				if (!placed) {
					int[][] sides = { { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 } };

					for (int i = 0; i < sides.length; i++) {
						int r = sides[i][0];
						int c = sides[i][1];

						if (board[r][c] == ' ') {
							board[r][c] = 'O';
							break;
						}
					}
				}
			}
		}

		if (TicTacToe.checkTheWinner(board, 'O')) {
			TicTacToe.printing(board);
			System.out.println("Computer is Winner you bot!!!");
			return false;
		}

		TicTacToe.printing(board);
		return true;
	}
}
