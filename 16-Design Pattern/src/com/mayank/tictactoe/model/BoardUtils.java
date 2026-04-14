package com.mayank.tictactoe.model;

public class BoardUtils {
	public int countEmptyPosition(char[][] board, int count) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					count++;
				}
			}
		}
		return count;
	}
	
	public void printing(char[][] board) {
		System.out.println();
		int position = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					System.out.print(" " + position + " ");
				} else {
					System.out.print(" " + board[i][j] + " ");
				}
				if (j < 2) {
					System.out.print("|");
				}
				position++;
			}
			System.out.println();
			if (i < 2) {
				System.out.println("---+---+---");
			}
		}
		System.out.println();
	}
	
	public void resetBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
}
