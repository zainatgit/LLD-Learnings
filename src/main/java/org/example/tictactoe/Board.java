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

    public boolean getFreeSpace() {
        for(int i=0;i<size;i++){
            for(int j=0; j<size;j++){
                if(board[i][j]==null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addMove(Integer row, Integer col, PlayingPiece piece) {
        if(board[row][col] == null){
            board[row][col] = piece;
            return true;
        }
        return false;
    }

    public boolean checkWinner(Integer row, Integer col, PlayingPiece pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<size;i++) {

            if(board[row][i] == null || board[row][i] != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<size;i++) {

            if(board[i][col] == null || board[i][col] != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<size;i++,j++) {
            if (board[i][j] == null || board[i][j] != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=size-1; i<size;i++,j--) {
            if (board[i][j] == null || board[i][j] != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
