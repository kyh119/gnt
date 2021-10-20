package com.gnt.domain.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Summoner {

    private String accountId;
    private String name;
    @Id
    private String id;
    private String puuid;
    private int profileIconId;
    private Long summonerLevel;
    private Long revisionDate;

    @OneToMany(mappedBy = "summoner")
    private List<League> leagueList;

    @Builder
    public Summoner(String accountId, String name, String id, String puuid, Integer profileIconId, Long summonerLevel, Long revisionDate, List<League> leagueList) {
        this.accountId = accountId;
        this.name = name;
        this.id = id;
        this.puuid = puuid;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
        this.leagueList = leagueList;
    }

}
