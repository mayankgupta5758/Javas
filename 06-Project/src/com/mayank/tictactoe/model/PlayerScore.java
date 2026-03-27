package com.mayank.tictactoe.model;

public class PlayerScore {

    private String playerName;
    private int win;
    private int lose;
    private int tie;

    public PlayerScore(String playerName) {
        this.playerName = playerName;
    }

    public void increaseWin() {
        win++;
    }

    public void increaseLose() {
        lose++;
    }

    public void increaseTie() {
        tie++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void printScore() {
        System.out.println("Player: " + playerName);
        System.out.println("Wins: " + win);
        System.out.println("Loses: " + lose);
        System.out.println("Ties: " + tie);
        System.out.println("---------------------------");
    }
}