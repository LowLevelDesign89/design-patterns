package com.app.tictactoe.services;

import com.app.tictactoe.commons.Pair;
import com.app.tictactoe.models.Board;
import com.app.tictactoe.models.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Deque<Player> players;

    private int boardSize;

    private Scanner scanner = new Scanner(System.in);

    public Game(int boardSize, Player player1, Player player2) {
        this.boardSize = boardSize;
        initializeGame(player1, player2);
    }

    private void initializeGame(Player player1, Player player2) {
        players = new LinkedList<>();
        board = new Board(boardSize);
        players.addLast(player1);
        players.addLast(player2);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {
            Player currentPlayer = players.pollFirst();
            List<Pair<Integer, Integer>> freeCells = board.getFreeCells();
            if(freeCells.isEmpty()) {
                noWinner = false;
                break;
            }

            System.out.println("Current Player : " + currentPlayer.getName());
            System.out.println("Enter the position on the board: ");
            String[] currentPos = scanner.nextLine().split("\\s+");
            int row = Integer.parseInt(currentPos[0].trim());
            int col = Integer.parseInt(currentPos[1].trim());
            boolean addedPieceSuccessfully = board.setPiece(row, col, currentPlayer.getPlayingPiece());
            if(!addedPieceSuccessfully) {
                System.out.println("Invalid move, try again");
                players.addFirst(currentPlayer);
                continue;
            }

            board.setPiece(row, col, currentPlayer.getPlayingPiece());
            if(board.hasWinner(currentPlayer.getPlayingPiece(), row, col)) {
                return currentPlayer.getName();
            }
            players.addLast(currentPlayer);

        }
        return "tie";
    }
}
