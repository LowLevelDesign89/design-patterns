package com.app.cricbuzz.match;

public class OneDayMatch implements MatchType{
    @Override
    public int numberOfOvers() {
        return 50;
    }

    @Override
    public int numberOfOversPerBowler() {
        return 10;
    }
}
