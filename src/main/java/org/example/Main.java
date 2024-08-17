package org.example;

import org.example.tictactoe.Game;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        Game game = new Game();
        System.out.println("Winner is : "+game.startGame());
    }
}