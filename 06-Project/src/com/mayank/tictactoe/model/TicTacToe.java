package com.mayank.tictactoe.model;

import java.util.*;

public class TicTacToe {
	static String minusLine = "--------------------------------------------------------------------";
	static String equalLine = "====================================================================";

	public static void resetBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean play = true;
		char[][] board = new char[3][3];
		resetBoard(board);

		while (play) {
			try {
				System.out.println(
						"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
				System.out.println("For Play with Friends press 1.");
				System.out.println("For play with computer press 2.");
				System.out.println("For Exit press 3.");
				board = new char[3][3];
				resetBoard(board);
				TicTacToe.printing(board);
				int n = scanner.nextInt();

				switch (n) {
				case 1:
					board = new char[3][3];
					resetBoard(board);
					TicTacToe.humanVsHuman(board, scanner, n);
					break;
				case 2:
					board = new char[3][3];
					resetBoard(board);
					TicTacToe.humanVsComputer(board, scanner, n);
					break;
				case 3:
					System.out.println("Thank's for Playing.");
					play = false;
					break;
				default:
					System.out.println("Please Enter 1, 2 or 3.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter Integer Value Only!!!.");
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	public static boolean checkTheWinner(char[][] board, char ch) {

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

	public static boolean checkTwoNear(char[][] board, char ch, char putChar) {

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

	public static void printing(char[][] board) {
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

	public static void inputRowAndCol(char[][] board, Scanner scanner, int playerNumber, int n) {

		while (true) {
			try {
				System.out.println("Player " + playerNumber + " enter position (1-9): ");
				int position = scanner.nextInt();

				if (position < 1 || position > 9) {
					System.out.println("Enter number between 1 and 9 only!");
					continue;
				}

				int row = (position - 1) / 3;
				int col = (position - 1) % 3;

				if (board[row][col] == 'X' || board[row][col] == 'O') {
					System.out.println("Position already occupied! Try again.");
					continue;
				}

				board[row][col] = (playerNumber == 1) ? 'X' : 'O';
				break;

			} catch (InputMismatchException e) {
				System.out.println("Enter integer value only!");
				scanner.nextLine();
			}
		}
	}

	public static int countEmptyPosition(char[][] board, int count) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					count++;
				}
			}
		}
		return count;
	}

	public static void humanVsHuman(char[][] board, Scanner scanner, int n) {
		System.out.println("Let's Start Human V/S Human.");

		Random random = new Random();
		int firstMove = random.nextInt(2) + 1;
		int secondMove = firstMove == 1 ? 2 : 1;
		System.out.println(firstMove + " " + secondMove);
		boolean move = true;
		while (move) {
			System.out.println(equalLine);
			move = PlayerTurn.humanPlayerTurn(board, scanner, firstMove, n);
			if (move == false) {
				return;
			}

			System.out.println(minusLine);
			move = PlayerTurn.humanPlayerTurn(board, scanner, secondMove, n);
			if (move == false) {
				return;
			}
		}
	}

	public static void humanVsComputer(char[][] board, Scanner scanner, int n) {
		System.out.println("Let's Start Human V/S Computer.");
		boolean move = true;
		Random random = new Random();

		int firstMove = random.nextInt(2) + 1;
		int secondMove = firstMove == 1 ? 2 : 1;

		System.out.println("First Move: " + (firstMove == 1 ? "Human" : "Computer"));

		while (move) {
			System.out.println(equalLine);

			if (firstMove == 1) {
				move = PlayerTurn.humanPlayerTurn(board, scanner, firstMove, n);
				if (!move)
					return;

				System.out.println(minusLine);

				move = ComputerTurn.computerTurn(board, scanner, secondMove);
				if (!move)
					return;
			} else {
				move = ComputerTurn.computerTurn(board, scanner, firstMove);
				if (!move)
					return;

				System.out.println(minusLine);

				move = PlayerTurn.humanPlayerTurn(board, scanner, secondMove, n);
				if (!move)
					return;
			}
		}
	}
}
