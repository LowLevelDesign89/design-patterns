package com.app.snakeladder.runner;

import com.app.snakeladder.service.Game;

public class SnakeLadderTest {
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("Winner is : " + game.startGame().getId());
    }
}
