package com.yhsh.gnimty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {
    @JsonProperty
    private String queueType;
    @JsonProperty
    private String tier;
    @JsonProperty
    private String rank;
    @JsonProperty
    private Integer leaguePoints;
    @JsonProperty
    private Integer wins;
    @JsonProperty
    private Integer losses;

    public League() {}

    public League(String queueType, String tier, String rank, Integer leaguePoints, Integer wins, Integer losses) {
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(Integer leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }
}
