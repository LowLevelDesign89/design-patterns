package com.app.cricbuzz.match.innings;

import com.app.cricbuzz.match.team.Team;
import com.app.cricbuzz.match.team.player.Player;

import java.util.List;

public class OverDetails {
    private int overNumber;
    private List<BallDetails> balls;
    private int extraBallCount;
    private Player bowledBy;

    public OverDetails(int overNumber, Player bowledBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) {
        return true;
    }
}
