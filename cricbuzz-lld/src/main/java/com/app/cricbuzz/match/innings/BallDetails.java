package com.app.cricbuzz.match.innings;

import com.app.cricbuzz.match.scoreupdater.BattingScoreUpdaterObserver;
import com.app.cricbuzz.match.scoreupdater.BowlingScoreUpdaterObserver;
import com.app.cricbuzz.match.scoreupdater.ScoreUpdaterObserver;
import com.app.cricbuzz.match.team.player.Player;

import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    private int ballNumber;
    private BallType ballType;
    private RunType runType;
    private Player playedBy;
    private Player bowledBy;
    private List<ScoreUpdaterObserver> scoreUpdaterObserverList;

    public BallDetails(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList = new ArrayList<>();
        scoreUpdaterObserverList.add(new BattingScoreUpdaterObserver());
        scoreUpdaterObserverList.add(new BowlingScoreUpdaterObserver());

    }
}
