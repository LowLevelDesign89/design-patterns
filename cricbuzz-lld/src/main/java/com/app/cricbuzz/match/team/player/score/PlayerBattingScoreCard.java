package com.app.cricbuzz.match.team.player.score;

import com.app.cricbuzz.match.team.Wicket;

public class PlayerBattingScoreCard {
    private int totalRunsScored;
    private int totalBallsPlayed;
    private int numOfFours;
    private int numOfSixes;
    private double strikeRate;
    private Wicket wicketDetails;

    public int getTotalRunsScored() {
        return totalRunsScored;
    }

    public void setTotalRunsScored(int totalRunsScored) {
        this.totalRunsScored = totalRunsScored;
    }

    public int getTotalBallsPlayed() {
        return totalBallsPlayed;
    }

    public void setTotalBallsPlayed(int totalBallsPlayed) {
        this.totalBallsPlayed = totalBallsPlayed;
    }

    public int getNumOfFours() {
        return numOfFours;
    }

    public void setNumOfFours(int numOfFours) {
        this.numOfFours = numOfFours;
    }

    public int getNumOfSixes() {
        return numOfSixes;
    }

    public void setNumOfSixes(int numOfSixes) {
        this.numOfSixes = numOfSixes;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Wicket getWicketDetails() {
        return wicketDetails;
    }

    public void setWicketDetails(Wicket wicketDetails) {
        this.wicketDetails = wicketDetails;
    }
}
