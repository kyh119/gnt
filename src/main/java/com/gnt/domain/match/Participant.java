package com.gnt.domain.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gnt.domain.summoner.Summoner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Participant {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Info info;

    @OneToOne
    @JoinColumn(name = "puuid")
    private Summoner summoner;

    private int assists;
    private int champLevel;
    private int championId;
    private String championName;
    private int championTransform;
    private int deaths;
    private int detectorWardsPlaced;
    private boolean firstBloodKill;
    private boolean firstTowerKill;
    private int goldEarned;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int kills;
    private int largestCriticalStrike;
    private int largestKillingSpree;
    private int largestMultiKill;
    private int longestTimeSpentLiving;
    private int neutralMinionsKilled;
    private int objectiveStolen;
    private int sightWardsBoughtInGame;
    private int summoner1Id;
    private int summoner2Id;
    private String summonerName;
    private int teamId;
    private int totalDamageDealtToChampions;
    private int totalDamageShieldedOnTeammates;
    private int totalDamageTaken;
    private int totalHealsOnTeammates;
    private int totalMinionsKilled;
    private int totalTimeCCDealt;
    private int totalTimeSpentDead;
    private int turretKills;
    private int visionScore;
    private int visionWardsBoughtInGame;
    private int wardsKilled;
    private int wardsPlaced;
    private boolean win;

}
