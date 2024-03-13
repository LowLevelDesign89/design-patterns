package com.app.tictactoe;

import com.app.tictactoe.models.Player;
import com.app.tictactoe.models.PlayingPieceO;
import com.app.tictactoe.models.PlayingPieceX;
import com.app.tictactoe.services.Game;

public class TicTacToeTest {
    public static void main(String[] args) {
        Player player1 = new Player(new PlayingPieceX(), "player1");
        Player player2 = new Player(new PlayingPieceO(), "player2");
        Game game = new Game(3, player1, player2);

        String name = game.startGame();
        System.out.println("Winner is : " + name);
    }
}
