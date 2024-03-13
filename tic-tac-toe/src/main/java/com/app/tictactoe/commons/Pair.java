package com.app.tictactoe.commons;

public class Pair<S, T> {
    private S first;
    private T second;

    private Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public static<S, T> Pair<S, T> of(S first, T second) {
        return new Pair<>(first, second);
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}
