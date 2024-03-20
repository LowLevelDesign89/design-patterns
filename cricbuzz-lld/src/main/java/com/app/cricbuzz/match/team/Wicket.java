package com.app.cricbuzz.match.team;

import com.app.cricbuzz.match.innings.BallDetails;
import com.app.cricbuzz.match.innings.OverDetails;
import com.app.cricbuzz.match.team.player.Player;

public class Wicket {
    private WicketType wicketType;
    private Player takenBy;
    private OverDetails overDetails;
    private BallDetails ballDetails;

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public Player getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(Player takenBy) {
        this.takenBy = takenBy;
    }

    public OverDetails getOverDetails() {
        return overDetails;
    }

    public void setOverDetails(OverDetails overDetails) {
        this.overDetails = overDetails;
    }

    public BallDetails getBallDetails() {
        return ballDetails;
    }

    public void setBallDetails(BallDetails ballDetails) {
        this.ballDetails = ballDetails;
    }
}
