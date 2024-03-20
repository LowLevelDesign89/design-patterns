package com.app.cricbuzz.match;

public class T20Match implements MatchType{
    @Override
    public int numberOfOvers() {
        return 20;
    }

    @Override
    public int numberOfOversPerBowler() {
        return 5;
    }
}
