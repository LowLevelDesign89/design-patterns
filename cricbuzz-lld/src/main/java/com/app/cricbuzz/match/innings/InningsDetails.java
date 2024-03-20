package com.app.cricbuzz.match.innings;

import com.app.cricbuzz.match.MatchType;
import com.app.cricbuzz.match.team.Team;

import java.util.ArrayList;
import java.util.List;

public class InningsDetails {
    private Team battingTeam;
    private Team bowlingTeam;
    private List<OverDetails> overs;
    private MatchType matchType;

    public InningsDetails(MatchType matchType) {
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public void start(int runsToWin) {

        int numberOfOvers = matchType.numberOfOvers();
        battingTeam.chooseNextBatsMan();

        for(int over = 1; over <= numberOfOvers; over++) {
            bowlingTeam.chooseNextBowler(matchType.numberOfOversPerBowler());
            
            OverDetails overDetails = new OverDetails(over, bowlingTeam.getCurrentBowler());
            overs.add(overDetails);

            try {
                boolean won = overDetails.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won) {
                    break;
                }
            } catch (Exception exception) {
                break;
            }
        }
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }
}
