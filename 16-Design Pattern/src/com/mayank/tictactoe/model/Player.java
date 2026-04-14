package com.mayank.tictactoe.model;

import java.util.Scanner;

public interface Player {
	boolean playMove(char[][] board, Scanner scanner, int playerNumber, int n);
}
