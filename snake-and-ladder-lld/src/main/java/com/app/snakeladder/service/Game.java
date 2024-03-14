package com.app.snakeladder.service;

import com.app.snakeladder.models.*;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Dice dice;
    private Deque<Player> players;
    private Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        addPlayers();
    }

    private void addPlayers() {
        players = new LinkedList<>();
        players.add(new Player("Player1", 0));
        players.add(new Player("Player2", 0));
    }

    public Player startGame() {
        while(winner == null) {
            Player player = players.removeFirst();
            System.out.println("Player turn is : " + player.getId() + " <=> Current Position is : " + player.getCurrentPosition());

            int newPosition = dice.rollDice();
            int playerNewPosition = player.getCurrentPosition() + newPosition;
            playerNewPosition = jumpCheck(playerNewPosition);
            player.setCurrentPosition(playerNewPosition);
            players.addLast(player);

            System.out.println("Player turn is : " + player.getId() + " <=> New Position is : " + player.getCurrentPosition());
            if(playerNewPosition >= board.getSize() * board.getSize() - 1) {
                winner = player;
            }
        }
        return winner;
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition >= board.getSize() * board.getSize() - 1) {
            return playerNewPosition;
        }
        int row = playerNewPosition / board.getSize();
        int col = playerNewPosition % board.getSize();
        Cell cell = board.getBoard()[row][col];
        if(cell.getJump() == null)
            return playerNewPosition;
        Jump jump = cell.getJump();
        String jumpType = jump.getStart() > jump.getEnd() ? "snake": "ladder";
        System.out.println("Player has been caught by : " + jumpType);
        playerNewPosition = jump.getEnd();
        return playerNewPosition;
    }


}
