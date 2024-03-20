package com.app.cricbuzz.match;

import com.app.cricbuzz.match.innings.InningsDetails;
import com.app.cricbuzz.match.team.Team;

import java.util.Date;
import java.util.Random;

public class Match {
    private Team teamA;
    private Team teamB;
    private Team tossWon;
    private Date commencedOn;
    private String venue;
    private MatchType matchType;
    private InningsDetails[] inningsDetails;

    public Match(Team teamA, Team teamB, Date commencedOn, String venue, MatchType matchType) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.commencedOn = commencedOn;
        this.venue = venue;
        this.matchType = matchType;
    }

    public void startMatch() {
        tossWon = playToss();
        this.inningsDetails = new InningsDetails[2];
        Team battingTeam = tossWon;
        Team bowlingTeam = tossWon.equals(teamA) ? teamB: teamA;
        for(int inning = 1; inning <= inningsDetails.length; inning++) {
            InningsDetails currentDetails = new InningsDetails(matchType);
            if(inning == 1) {
                currentDetails.setBattingTeam(battingTeam);
                currentDetails.setBowlingTeam(bowlingTeam);
                currentDetails.start(-1);
            } else if(inning == 2) {
                currentDetails.setBattingTeam(bowlingTeam);
                currentDetails.setBowlingTeam(battingTeam);
                currentDetails.start(inningsDetails[0].getBattingTeam().getTotalRunsScored());
                if(bowlingTeam.getTotalRunsScored() > battingTeam.getTotalRunsScored()) {
                    bowlingTeam.setWinner(true);
                }
            }
            inningsDetails[inning - 1] = currentDetails;
        }
    }

    private Team playToss() {
        Random random = new Random();
        double value = random.nextDouble();
        if(value < 0.5)
            return teamA;
        else
            return teamB;
    }
}
