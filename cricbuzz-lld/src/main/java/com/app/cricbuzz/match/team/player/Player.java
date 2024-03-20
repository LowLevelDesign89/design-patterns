package com.app.cricbuzz.match.team.player;

import com.app.cricbuzz.match.team.player.score.PlayerBattingScoreCard;
import com.app.cricbuzz.match.team.player.score.PlayerBowlingScoreCard;

public class Player {
    private Person person;
    private PlayerType playerType;
    private PlayerBattingScoreCard playerBattingScoreCard;
    private PlayerBowlingScoreCard playerBowlingScoreCard;

    public Player(Person person, PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        playerBattingScoreCard = new PlayerBattingScoreCard();
        playerBowlingScoreCard = new PlayerBowlingScoreCard();
    }

    public PlayerBattingScoreCard getPlayerBattingScoreCard() {
        return playerBattingScoreCard;
    }

    public void setPlayerBattingScoreCard(PlayerBattingScoreCard playerBattingScoreCard) {
        this.playerBattingScoreCard = playerBattingScoreCard;
    }

    public PlayerBowlingScoreCard getPlayerBowlingScoreCard() {
        return playerBowlingScoreCard;
    }

    public void setPlayerBowlingScoreCard(PlayerBowlingScoreCard playerBowlingScoreCard) {
        this.playerBowlingScoreCard = playerBowlingScoreCard;
    }
}
