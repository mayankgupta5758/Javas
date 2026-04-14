package com.mayank.tictactoe.model;

import java.util.Random;
import java.util.Scanner;

public class GameFacade {
	private HumanTurn humanTurn = new HumanTurn();
	private ComputerTurn computerTurn = new ComputerTurn();
	String minusLine = "--------------------------------------------------------------------";
	String equalLine = "====================================================================";
	
	public void humanVsHuman(char[][] board, Scanner scanner, int n) {
		System.out.println("Let's Start Human V/S Human.");

		Random random = new Random();
		int firstMove = random.nextInt(2) + 1;
		int secondMove = firstMove == 1 ? 2 : 1;
		System.out.println(firstMove + " " + secondMove);
		boolean move = true;
		while (move) {
			System.out.println(equalLine);
			move = humanTurn.playMove(board, scanner, firstMove, n);
			if (move == false) {
				return;
			}

			System.out.println(minusLine);
			move = humanTurn.playMove(board, scanner, secondMove, n);
			if (move == false) {
				return;
			}
		}
	}
	
	public void humanVsComputer(char[][] board, Scanner scanner, int n) {
		System.out.println("Let's Start Human V/S Computer.");
		boolean move = true;
		Random random = new Random();

		int firstMove = random.nextInt(2) + 1;
		int secondMove = firstMove == 1 ? 2 : 1;

		System.out.println("First Move: " + (firstMove == 1 ? "Human" : "Computer"));

		while (move) {
			System.out.println(equalLine);

			if (firstMove == 1) {
				move = humanTurn.playMove(board, scanner, firstMove, n);
				if (!move)
					return;

				System.out.println(minusLine);

				move = computerTurn.playMove(board, scanner, secondMove, n);
				
				if (!move)
					return;
			} else {
				move = computerTurn.playMove(board, scanner, firstMove, n);
				if (!move)
					return;

				System.out.println(minusLine);

				move = humanTurn.playMove(board, scanner, secondMove, n);
				if (!move)
					return;
			}
		}
	}
}
