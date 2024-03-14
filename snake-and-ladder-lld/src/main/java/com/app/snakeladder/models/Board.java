package com.app.snakeladder.models;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private final int size;
    private Cell[][] board;

    public Board(int size, int numberOfSnakes, int numberOfLadders) {
        this.size = size;
        this.board = new Cell[size][size];

        initializeCells();
        initializeSnakesAndLadders(numberOfSnakes, numberOfLadders);
    }

    private void initializeCells() {
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                board[row][col] = new Cell();
            }
        }
    }

    private void initializeSnakesAndLadders(int numberOfSnakes, int numberOfLadders) {
        Set<Integer> snakePositions = new HashSet<>();
        int min = 1;
        int max = size * size - 1;
        while(numberOfSnakes > 0) {
            int startPos = ThreadLocalRandom.current().nextInt(min, max);
            int endPos = ThreadLocalRandom.current().nextInt(min, max);
            if(startPos <= endPos)
                continue;
            Jump jump = new Jump(startPos, endPos);

            Cell cell = getCell(startPos);
            cell.setJump(jump);

            snakePositions.add(startPos);
            snakePositions.add(endPos);
            numberOfSnakes--;
        }

        while(numberOfLadders > 0) {
            int startPos = ThreadLocalRandom.current().nextInt(min, max);
            int endPos = ThreadLocalRandom.current().nextInt(min, max);
            if(startPos <= endPos || snakePositions.contains(startPos) || snakePositions.contains(endPos))
                continue;
            Jump jump = new Jump(startPos, endPos);

            Cell cell = getCell(startPos);
            cell.setJump(jump);

            numberOfLadders--;
        }

    }

    private Cell getCell(int position) {
        int row = position / size;
        int col = position % size;
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getBoard() {
        return board;
    }
}
