package com.app.snakeladder.models;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int min = 1;
    private final int max = 6;
    private int diceCount;
    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int i = 0;
        int totalCount = 0;
        while(i < diceCount) {
            totalCount += ThreadLocalRandom.current().nextInt(min, max + 1);
            i++;
        }
        return totalCount;
    }
}
