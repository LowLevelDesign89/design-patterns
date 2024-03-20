package com.app.cricbuzz.match.team.player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PlayerBattingController {
    private Deque<Player> batters;
    private Player striker;
    private Player nonStriker;

    public PlayerBattingController(List<Player> battersList) {
        batters = new LinkedList<>();
        for(Player player: battersList) {
            batters.addLast(player);
        }
    }

    public int getTotalRuns() {
        int totalRunsScored = 0;
        for(Player player: batters) {
            totalRunsScored += player.getPlayerBattingScoreCard().getTotalRunsScored();
        }
        return totalRunsScored;
    }

    public void chooseNextBatsman() {
        if(batters.isEmpty()) {
            throw new RuntimeException("Bad Request");
        }

        if(striker == null) {
            striker = batters.poll();
        }

        if(nonStriker == null) {
            nonStriker = batters.poll();
        }
    }
}
