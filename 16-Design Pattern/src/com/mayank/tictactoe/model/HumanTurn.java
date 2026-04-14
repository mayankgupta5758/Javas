package com.mayank.tictactoe.model;

import java.util.Scanner;

public class HumanTurn implements Player{
	private BoardUtils boardUtils = new BoardUtils();
	private GameRules gameRules = new GameRules();
	private InputFromUser inputFromUser = new InputFromUser();

	@Override
	public boolean playMove(char[][] board, Scanner scanner, int playerNumber, int n) {
		System.out.println("Player " + playerNumber + " tern.");
		int countEmptyforPlayer = boardUtils.countEmptyPosition(board, 0);
		if (countEmptyforPlayer == 0) {
			System.out.println("No Available positions");
			System.out.println("Tie! No One Wins the Game.");
			return false;
		}

		inputFromUser.inputRowAndCol(board, scanner, playerNumber, n);

		if(n == 2) {
			if (gameRules.checkTheWinner(board, 'X')) {
				boardUtils.printing(board);
				System.out.println("Player "+ playerNumber +" is Winner");
				return false;
			}
		} else {
			if (playerNumber == 1) {
				if (gameRules.checkTheWinner(board, 'X')) {
					boardUtils.printing(board);
					System.out.println("Player 1 is Winner");
					return false;
				}
			} else {
				if (gameRules.checkTheWinner(board, 'O')) {
					boardUtils.printing(board);
					System.out.println("Player 2 is Winner");
					return false;
				}
			}
		}

		boardUtils.printing(board);
		return true;
	}

}
