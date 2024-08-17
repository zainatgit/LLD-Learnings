package org.example.tictactoe;

import java.util.Deque;
import java.util.LinkedList;

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
        playerDeque.add(player2);
        playerDeque.add(player1);
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
            break;
        }

        //In case of no winner game is tie
        return "tie";
    }


}
