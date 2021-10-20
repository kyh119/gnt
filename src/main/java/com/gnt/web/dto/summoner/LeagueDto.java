package com.gnt.web.dto.summoner;

import com.gnt.domain.summoner.League;
import lombok.Getter;

@Getter
public class LeagueDto {
    private String queueType;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean freshBlood;

    public LeagueDto(League league) {
        this.queueType = league.getQueueType();
        this.tier = league.getTier();
        this.rank = league.getRank();
        this.leaguePoints = league.getLeaguePoints();
        this.wins = league.getLeaguePoints();
        this.losses = league.getLosses();
        this.hotStreak = league.isHotStreak();
        this.freshBlood = league.isFreshBlood();
    }
}
