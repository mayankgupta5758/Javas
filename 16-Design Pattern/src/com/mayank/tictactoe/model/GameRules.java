package com.mayank.tictactoe.model;

public class GameRules {

	public boolean checkTheWinner(char[][] board, char ch) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == ch && board[i][1] == ch && board[i][2] == ch) {
				return true;
			}
		}

		for (int j = 0; j < 3; j++) {
			if (board[0][j] == ch && board[1][j] == ch && board[2][j] == ch) {
				return true;
			}
		}

		if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) {
			return true;
		}

		if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) {
			return true;
		}

		return false;
	}

	public  boolean checkTwoNear(char[][] board, char ch, char putChar) {
		for (int i = 0; i < 3; i++) {
			int count = 0;
			int emptyCol = -1;

			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ch)
					count++;
				if (board[i][j] == ' ')
					emptyCol = j;
			}

			if (count == 2 && emptyCol != -1) {
				board[i][emptyCol] = putChar;
				return true;
			}
		}

		for (int j = 0; j < 3; j++) {
			int count = 0;
			int emptyRow = -1;

			for (int i = 0; i < 3; i++) {
				if (board[i][j] == ch)
					count++;
				if (board[i][j] == ' ')
					emptyRow = i;
			}

			if (count == 2 && emptyRow != -1) {
				board[emptyRow][j] = putChar;
				return true;
			}
		}

		int count = 0;
		int emptyIndex = -1;

		for (int i = 0; i < 3; i++) {
			if (board[i][i] == ch)
				count++;
			if (board[i][i] == ' ')
				emptyIndex = i;
		}

		if (count == 2 && emptyIndex != -1) {
			board[emptyIndex][emptyIndex] = putChar;
			return true;
		}

		count = 0;
		int emptyRow = -1;
		int emptyCol = -1;

		for (int i = 0; i < 3; i++) {
			if (board[i][2 - i] == ch)
				count++;
			if (board[i][2 - i] == ' ') {
				emptyRow = i;
				emptyCol = 2 - i;
			}
		}

		if (count == 2 && emptyRow != -1) {
			board[emptyRow][emptyCol] = putChar;
			return true;
		}

		return false;
	}
}
