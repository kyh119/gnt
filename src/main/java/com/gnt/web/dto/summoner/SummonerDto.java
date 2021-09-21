package com.gnt.web.dto.summoner;

import com.gnt.web.dto.League;
import lombok.Getter;
import java.util.List;

@Getter
public class SummonerDto {
    private String name;
    private Integer profileIconId;
    private Long summonerLevel;
    private List<League> leagueList;

    public SummonerDto(Summoner summoner) {
        this.name = summoner.getName();
        this.profileIconId = summoner.getProfileIconId();
        this.summonerLevel = summoner.getSummonerLevel();
        this.leagueList = summoner.getLeagueList();
    }
}
