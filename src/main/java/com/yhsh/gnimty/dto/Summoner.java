package com.yhsh.gnimty.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Summoner {

    private String accountId;

    @JsonProperty
    private String name;

    private String id;

    private String puuid;

    @JsonProperty
    private Integer profileIconId;

    @JsonProperty
    private Long summonerLevel;

    @JsonProperty
    private Long revisionDate;

    private List<League> leagueList;

    public Summoner() {
    }

    public Summoner(String accountId, String name, String id, String puuid, Integer profileIconId, Long summonerLevel, Long revisionDate) {
        this.accountId = accountId;
        this.name = name;
        this.id = id;
        this.puuid = puuid;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
    }

    @JsonIgnore
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public String getPuuid() {
        return puuid;
    }

    @JsonProperty
    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Integer getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Integer profileIconId) {
        this.profileIconId = profileIconId;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public Long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
    }

    @JsonProperty
    public List<League> getLeagueList() {
        return leagueList;
    }

    public void setLeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
    }
}
