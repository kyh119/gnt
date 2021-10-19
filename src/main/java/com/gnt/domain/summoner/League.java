package com.gnt.domain.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table
public class League {

    private String summonerId;
    private String queueType;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean freshBlood;

    @Builder
    public League(String summonerId, String queueType, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean freshBlood) {
        this.summonerId = summonerId;
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.hotStreak = hotStreak;
        this.freshBlood = freshBlood;
    }
}
