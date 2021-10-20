package com.gnt.web.dto.summoner;

import com.gnt.domain.summoner.League;
import com.gnt.domain.summoner.Summoner;
import lombok.Getter;

@Getter
public class SummonerDto {
    private String name;
    private int profileIconId;
    private Long summonerLevel;
    private Long revisionDate;
    private LeagueDto soloLeague;
    private LeagueDto teamLeague;


    public SummonerDto(Summoner summoner) {
        this.name = summoner.getName();
        this.profileIconId = summoner.getProfileIconId();
        this.summonerLevel = summoner.getSummonerLevel();
        this.revisionDate = summoner.getRevisionDate();
        for (League league : summoner.getLeagueList()) {
            switch (league.getQueueType()) {
                case "RANKED_SOLO_5x5":
                    this.soloLeague = new LeagueDto(league);
                    break;
                case "RANKED_FLEX_SR":
                    this.teamLeague = new LeagueDto(league);
                    break;
            }
        }
    }
}
