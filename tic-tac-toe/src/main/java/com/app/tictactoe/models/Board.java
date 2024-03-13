package com.app.tictactoe.models;

import com.app.tictactoe.commons.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(board[row][col] == null) {
                    freeCells.add(Pair.of(row, col));
                }
            }
        }
        return freeCells;
    }

    public boolean setPiece(int row, int col, PlayingPiece playingPiece) {
        if(board[row][col] != null)
            return false;
        board[row][col] = playingPiece;
        return true;
    }

    public boolean hasWinner(PlayingPiece playingPiece, int row, int col) {
        boolean hasWon = true;

        // check column wise
        for(int c = 0; c < size; c++) {
            if(board[row][c] != playingPiece) {
                hasWon = false;
                break;
            }
        }

        if(hasWon)
            return true;

        hasWon = true;
        // check row wise
        for(int r = 0; r < size; r++) {
            if(board[r][col] != playingPiece) {
                hasWon = false;
                break;
            }
        }

        if(hasWon)
            return true;

        hasWon = true;
        for(int i = 0; i < size; i++) {
            if(board[i][i] != playingPiece) {
                hasWon = false;
                break;
            }
        }

        if(hasWon)
            return true;

        hasWon = true;
        int r = 0;
        int c = size - 1;
        while(r < size && c >= 0) {
            if(board[r][c] != playingPiece) {
                hasWon = false;
                break;
            }
            r++;
            c--;
        }
        return hasWon;
    }
}
