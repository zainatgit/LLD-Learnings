package org.example.tictactoe;

public class Board {
    int size;
    PlayingPiece[][] board;

    Board(int size){
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public void printBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].type.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }
}
