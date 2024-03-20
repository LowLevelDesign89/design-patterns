package com.app.cricbuzz.match.team.player;

import java.util.*;

public class PlayerBowlingController {
    private Deque<Player> bowlers;
    private Map<Player, Integer> playerOversMap;

    private Player currentBowler;

    public PlayerBowlingController(List<Player> bowlersList) {
        bowlers = new LinkedList<>();
        playerOversMap = new HashMap<>();

        for(Player player: bowlersList) {
            bowlers.addLast(player);
            playerOversMap.put(player, 0);
        }
    }

    public void chooseNextBowler(int maxOversToPlay) {
        currentBowler = bowlers.poll();

        if(playerOversMap.get(currentBowler) + 1 < maxOversToPlay) {
            bowlers.addLast(currentBowler);
            playerOversMap.put(currentBowler, playerOversMap.get(currentBowler) + 1);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }
}
