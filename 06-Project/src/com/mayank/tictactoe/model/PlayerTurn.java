package com.mayank.tictactoe.model;

import java.util.Scanner;

public class PlayerTurn {
	public static boolean humanPlayerTurn(char[][] board, Scanner scanner, int playerNumber, int n) {
		
		System.out.println("Player " + playerNumber + " tern.");
		int countEmptyforPlayer = TicTacToe.countEmptyPosition(board, 0);
		if (countEmptyforPlayer == 0) {
			System.out.println("No Available positions");
			System.out.println("Tie! No One Wins the Game.");
			return false;
		}

		TicTacToe.inputRowAndCol(board, scanner, playerNumber, n);

		if(n == 2) {
			if (TicTacToe.checkTheWinner(board, 'X')) {
				TicTacToe.printing(board);
				System.out.println("Player "+ playerNumber +" is Winner🎉🎉🎉");
				return false;
			}
		} else {
			if (playerNumber == 1) {
				if (TicTacToe.checkTheWinner(board, 'X')) {
					TicTacToe.printing(board);
					System.out.println("Player 1 is Winner🎉🎉🎉");
					return false;
				}
			} else {
				if (TicTacToe.checkTheWinner(board, 'O')) {
					TicTacToe.printing(board);
					System.out.println("Player 2 is Winner🎉🎉🎉");
					return false;
				}
			}
		}

		TicTacToe.printing(board);
		return true;
	}
}