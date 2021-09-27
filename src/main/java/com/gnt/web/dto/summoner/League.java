package com.gnt.web.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class League {

    private String queueType;
    private String tier;
    private String rank;
    private Integer leaguePoints;
    private Integer wins;
    private Integer losses;

    public League(String queueType, String tier, String rank, Integer leaguePoints, Integer wins, Integer losses) {
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
    }
}
