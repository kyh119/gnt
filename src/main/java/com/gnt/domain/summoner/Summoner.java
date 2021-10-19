package com.gnt.domain.summoner;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Summoner {

    private String accountId;
    private String name;
    private String id;

    @Id
    private String puuid;
    private int profileIconId;
    private long summonerLevel;
    private long revisionDate;

    @Builder
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
