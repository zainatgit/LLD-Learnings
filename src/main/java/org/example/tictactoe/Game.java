package org.example.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    Deque<Player> playerDeque;
    Board gameBoard;

    public Game(){
        initializeGame();
    }

    public void initializeGame(){
        //Add players
        Player player1 = new Player("Player1", new PieceX());
        Player player2 = new Player("Player2", new PieceO());

        playerDeque = new LinkedList<>();
        playerDeque.add(player1);
        playerDeque.add(player2);
        //We can also add feature of asking player their name and what piece they would like to choose and assign likewise

        this.gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;

        while(noWinner){

            //take out player whose turn it is
            Player playingPlayer = playerDeque.removeFirst();

            //Print the game board
            gameBoard.printBoard();

            //check if free space is availabe otherwise game is tie
            boolean freeSpaceAvailable = gameBoard.getFreeSpace();
            if(!freeSpaceAvailable){
                break;
            }

            //Take input from player for his move
            System.out.print(playingPlayer.name + " : Enter row,column : ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String value[] = s.split(",");
            Integer row = Integer.valueOf(value[0]);
            Integer col = Integer.valueOf(value[1]);

            //Add Move
            boolean validMove = gameBoard.addMove(row,col,playingPlayer.piece);
            if(validMove){
                boolean isWinner = gameBoard.checkWinner(row,col,playingPlayer.piece);
                if(isWinner){
                    return playingPlayer.getName() + " is the winner.";
                }
                //re add the player for next move
                playerDeque.add(playingPlayer);
            } else {
                System.out.println("Already occupied. Try again");
                //Adding first so that he gets another chance
                playerDeque.addFirst(playingPlayer);
            }
        }

        //In case of no winner game is tie
        return "tie";
    }

    //Check winenr is put in Game class and not in board class as this is function of game and not board.
    //If it was in Board class and If there were multiple instances of Game then it would cause problem.
    public boolean checkWinner(Integer row, Integer col, PlayingPiece pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i< gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i] != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i< gameBoard.size;i++) {

            if(gameBoard.board[i][col] == null || gameBoard.board[i][col] != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i< gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


}
