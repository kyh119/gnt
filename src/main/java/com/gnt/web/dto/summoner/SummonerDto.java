package com.gnt.web.dto.summoner;

import lombok.Getter;
import java.util.List;

@Getter
public class SummonerDto {
    private String accountId;
    private String name;
    private String id;
    private String puuid;
    private Integer profileIconId;
    private Long summonerLevel;
    private Long revisionDate;
    private League soloLeague;
    private League teamLeague;


    public SummonerDto(Summoner summoner) {
        this.name = summoner.getName();
        this.profileIconId = summoner.getProfileIconId();
        this.summonerLevel = summoner.getSummonerLevel();
        this.accountId = summoner.getAccountId();
        this.id = summoner.getId();
        this.puuid = summoner.getPuuid();
        this.revisionDate = summoner.getRevisionDate();
        for (League league : summoner.getLeagueList()) {
            switch (league.getQueueType()) {
                case "RANKED_SOLO_5x5":
                    this.soloLeague = league;
                    break;
                case "RANKED_FLEX_SR":
                    this.teamLeague = league;
                    break;
            }
        }
    }
}
