package com.app.cricbuzz.match.team;

import com.app.cricbuzz.match.team.player.Player;
import com.app.cricbuzz.match.team.player.PlayerBattingController;
import com.app.cricbuzz.match.team.player.PlayerBowlingController;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Team {
    private String teamName;
    private Deque<Player> players11;
    private List<Player> benchPlayers;
    private PlayerBattingController playerBattingController;
    private PlayerBowlingController playerBowlingController;

    private boolean isWinner;

    public Team(String teamName, List<Player> players, List<Player> benchPlayers, List<Player> batters, List<Player> bowlers) {
        this.teamName = teamName;
        players11 = new LinkedList<>();
        for(Player player: players) {
            players11.addLast(player);
        }
        this.benchPlayers = benchPlayers;
        playerBattingController = new PlayerBattingController(batters);
        playerBowlingController = new PlayerBowlingController(bowlers);
    }

    public int getTotalRunsScored() {
        return playerBattingController.getTotalRuns();
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public void chooseNextBatsMan() {
        playerBattingController.chooseNextBatsman();
    }

    public void chooseNextBowler(int maxOversToPlay) {
        playerBowlingController.chooseNextBowler(maxOversToPlay);
    }

    public Player getCurrentBowler() {
        return playerBowlingController.getCurrentBowler();
    }


}
