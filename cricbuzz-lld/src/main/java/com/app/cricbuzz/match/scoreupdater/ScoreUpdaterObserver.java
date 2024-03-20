package com.app.cricbuzz.match.scoreupdater;

import com.app.cricbuzz.match.innings.BallDetails;

public interface ScoreUpdaterObserver {
    void update(BallDetails ballDetails);
}
