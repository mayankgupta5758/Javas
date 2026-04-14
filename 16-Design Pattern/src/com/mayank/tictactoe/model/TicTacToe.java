package com.mayank.tictactoe.model;

import java.util.Scanner;

import com.mayank.tictactoe.exception.InvalidInputException;

public class TicTacToe {
	private BoardUtils boardUtils = new BoardUtils();
	private GameFacade gameFacade = new GameFacade();

//	public void start(Scanner scanner) {
//		boolean play = true;
//		char[][] board = new char[3][3];
//		boardUtils.resetBoard(board);
//
//		while (play) {
//			try {
//				System.out.println(
//						"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
//				System.out.println("For Play with Friends press 1.");
//				System.out.println("For play with computer press 2.");
//				System.out.println("For Exit press 3.");
//				board = new char[3][3];
//				boardUtils.resetBoard(board);
//				boardUtils.printing(board);
//				int n = scanner.nextInt();
//
//				switch (n) {
//				case 1:
//					board = new char[3][3];
//					boardUtils.resetBoard(board);
//					gameFacade.humanVsHuman(board, scanner, n);
//					break;
//				case 2:
//					board = new char[3][3];
//					boardUtils.resetBoard(board);
//					gameFacade.humanVsComputer(board, scanner, n);
//					break;
//				case 3:
//					System.out.println("Thank's for Playing.");
//					play = false;
//					break;
//				default:
//					System.out.println("Please Enter 1, 2 or 3.");
//					break;
//				}
//			} catch (InputMismatchException e) {
//				System.out.println("Enter Integer Value Only!!!.");
//				scanner.nextLine();
//			}
//		}
//		scanner.close();
//	}

	public void start(Scanner scanner) {
		boolean play = true;
		char[][] board = new char[3][3];
		boardUtils.resetBoard(board);

		while (play) {
			try {
				System.out.println(
						"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
				System.out.println("For Play with Friends press 1.");
				System.out.println("For play with computer press 2.");
				System.out.println("For Exit press 3.");

				board = new char[3][3];
				boardUtils.resetBoard(board);
				boardUtils.printing(board);

				if (!scanner.hasNextInt()) {
					throw new InvalidInputException("Only integer values are allowed!");
				}

				int n = scanner.nextInt();

				switch (n) {
				case 1:
					board = new char[3][3];
					boardUtils.resetBoard(board);
					gameFacade.humanVsHuman(board, scanner, n);
					break;

				case 2:
					board = new char[3][3];
					boardUtils.resetBoard(board);
					gameFacade.humanVsComputer(board, scanner, n);
					break;

				case 3:
					System.out.println("Thank's for Playing.");
					play = false;
					break;

				default:
					throw new InvalidInputException("Please Enter 1, 2 or 3 only!");
				}

			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
				scanner.nextLine();
			}
		}
		scanner.close();
	}
}
