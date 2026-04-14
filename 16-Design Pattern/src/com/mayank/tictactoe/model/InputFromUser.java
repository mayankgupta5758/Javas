package com.mayank.tictactoe.model;

import java.util.Scanner;
import com.mayank.tictactoe.exception.InvalidInputException;
import com.mayank.tictactoe.exception.InvalidPositionException;
import com.mayank.tictactoe.exception.PositionAlreadyOccupiedException;

public class InputFromUser {

    public void inputRowAndCol(char[][] board, Scanner scanner, int playerNumber, int n) {

        while (true) {
            try {
                System.out.println("Player " + playerNumber + " enter position (1-9): ");

                if (!scanner.hasNextInt()) {
                    throw new InvalidInputException("Enter integer value only!");
                }

                int position = scanner.nextInt();

                if (position < 1 || position > 9) {
                    throw new InvalidPositionException("Enter number between 1 and 9 only!");
                }

                int row = (position - 1) / 3;
                int col = (position - 1) % 3;

                if (board[row][col] == 'X' || board[row][col] == 'O') {
                    throw new PositionAlreadyOccupiedException("Position already occupied! Try again.");
                }

                board[row][col] = (playerNumber == 1) ? 'X' : 'O';
                break;

            } catch (InvalidInputException | InvalidPositionException | PositionAlreadyOccupiedException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }
}