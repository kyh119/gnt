package com.gnt.web.dto.summoner;

import com.gnt.web.dto.League;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class Summoner {

    private String accountId;
    private String name;
    private String id;
    private String puuid;
    private Integer profileIconId;
    private Long summonerLevel;
    private Long revisionDate;
    private List<League> leagueList;

    public Summoner(String accountId, String name, String id, String puuid, Integer profileIconId, Long summonerLevel, Long revisionDate) {
        this.accountId = accountId;
        this.name = name;
        this.id = id;
        this.puuid = puuid;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
    }

}
