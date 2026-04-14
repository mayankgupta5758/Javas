package com.mayank.tictactoe.test;

import java.util.Scanner;

import com.mayank.tictactoe.model.TicTacToe;

public class TicTacToeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TicTacToe tictactoe = new TicTacToe();
		tictactoe.start(scanner);
		scanner.close();
	}
}
