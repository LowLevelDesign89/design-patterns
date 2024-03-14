package com.app.snakeladder.models;

public class Player {
    private final String id;
    private int currentPosition;

    public Player(String id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getId() {
        return id;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
