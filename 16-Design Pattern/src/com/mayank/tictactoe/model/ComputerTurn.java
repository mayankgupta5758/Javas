package com.mayank.tictactoe.model;

import java.util.Random;
import java.util.Scanner;

public class ComputerTurn implements Player {
	private BoardUtils boardUtils = new BoardUtils();
	private GameRules gameRules = new GameRules();

	@Override
	public boolean playMove(char[][] board, Scanner scanner, int playerNumber, int n) {
		System.out.println("Computer tern.");

		int countEmptyforPlayer = boardUtils.countEmptyPosition(board, 0);

		if (countEmptyforPlayer == 0) {
			System.out.println("Tie! No One Wins the Game.");
			return false;
		}

		if (gameRules.checkTwoNear(board, 'O', 'O')) {
			// winning move placed
		}

		else if (gameRules.checkTwoNear(board, 'X', 'O')) {
			// blocking move placed
		}

		else {

			if (board[1][1] == ' ') {
				board[1][1] = 'O';
			}

			/*
			 * // else { // int[][] corners = { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 2, 2 } }; //
			 * boolean placed = false; // // for (int i = 0; i < corners.length; i++) { //
			 * int r = corners[i][0]; // int c = corners[i][1]; // // if (board[r][c] == '
			 * ') { // board[r][c] = 'O'; // placed = true; // break; // } // } // // if
			 * (!placed) { // int[][] sides = { { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 } }; //
			 * // for (int i = 0; i < sides.length; i++) { // int r = sides[i][0]; // int c
			 * = sides[i][1]; // // if (board[r][c] == ' ') { // board[r][c] = 'O'; //
			 * break; // } // } // }
			 */
			else {
				Random random = new Random();

				while (true) {
					int position = random.nextInt(9) + 1;

					int row = (position - 1) / 3;
					int col = (position - 1) % 3;

					if (board[row][col] == ' ') {
						board[row][col] = 'O';
						break;
					}
				}
			}
//			}
		}

		if (gameRules.checkTheWinner(board, 'O')) {
			boardUtils.printing(board);
			System.out.println("Computer is Winner you bot!!!");
			return false;
		}

		boardUtils.printing(board);
		return true;
	}

}
