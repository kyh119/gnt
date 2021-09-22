package com.gnt.web.dto.summoner;

import lombok.Getter;
import java.util.List;

@Getter
public class SummonerDto {
    private String name;
    private Integer profileIconId;
    private Long level;
    private League soloLeague;
    private League teamLeague;

    public SummonerDto(Summoner summoner) {
        this.name = summoner.getName();
        this.profileIconId = summoner.getProfileIconId();
        this.level = summoner.getSummonerLevel();
        for (League league : summoner.getLeagueList()) {
            switch (league.getQueueType()) {
                case "RANKED_SOLO_5x5":
                    this.soloLeague = league;
                    break;
                case "RANKED_TEAM_5x5":
                    this.teamLeague = league;
                    break;
            }
        }
    }
}
