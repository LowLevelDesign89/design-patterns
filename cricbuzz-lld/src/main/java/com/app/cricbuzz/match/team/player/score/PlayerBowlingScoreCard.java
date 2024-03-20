package com.app.cricbuzz.match.team.player.score;

public class PlayerBowlingScoreCard {
    private int totalOversCount;
    private int totalRunsGiven;
    private int wicketsTaken;
    private int noBallsCount;
    private int wideBallsCount;
    private double economyRate;

    public int getTotalOversCount() {
        return totalOversCount;
    }

    public void setTotalOversCount(int totalOversCount) {
        this.totalOversCount = totalOversCount;
    }

    public int getTotalRunsGiven() {
        return totalRunsGiven;
    }

    public void setTotalRunsGiven(int totalRunsGiven) {
        this.totalRunsGiven = totalRunsGiven;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getNoBallsCount() {
        return noBallsCount;
    }

    public void setNoBallsCount(int noBallsCount) {
        this.noBallsCount = noBallsCount;
    }

    public int getWideBallsCount() {
        return wideBallsCount;
    }

    public void setWideBallsCount(int wideBallsCount) {
        this.wideBallsCount = wideBallsCount;
    }

    public double getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(double economyRate) {
        this.economyRate = economyRate;
    }
}
