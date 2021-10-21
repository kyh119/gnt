package com.gnt.domain.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gnt.domain.summoner.Summoner;
import lombok.Builder;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Info info;

    @OneToOne
    @JoinColumn(name = "puuid", referencedColumnName = "puuid")
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

    @Column(name = "summoner1_id")
    private int summoner1Id;

    @Column(name = "summoner2_id")
    private int summoner2Id;

    private String summonerName;
    private int teamId;
    private int totalDamageDealtToChampions;
    private int totalDamageShieldedOnTeammates;
    private int totalDamageTaken;
    private int totalHealsOnTeammates;
    private int totalMinionsKilled;

    @Column(name = "total_time_cc_dealt")
    private int totalTimeCCDealt;
    private int totalTimeSpentDead;
    private int turretKills;
    private int visionScore;
    private int visionWardsBoughtInGame;
    private int wardsKilled;
    private int wardsPlaced;
    private boolean win;

    @OneToOne
    @JoinColumn(name = "perks_id")
    private Perks perks;

    @Builder
    public Participant(Info info, Summoner summoner, int assists, int champLevel, int championId, String championName, int championTransform, int deaths, int detectorWardsPlaced, boolean firstBloodKill, boolean firstTowerKill, int goldEarned, int item0, int item1, int item2, int item3, int item4, int item5, int item6, int kills, int largestCriticalStrike, int largestKillingSpree, int largestMultiKill, int longestTimeSpentLiving, int neutralMinionsKilled, int objectiveStolen, int sightWardsBoughtInGame, int summoner1Id, int summoner2Id, String summonerName, int teamId, int totalDamageDealtToChampions, int totalDamageShieldedOnTeammates, int totalDamageTaken, int totalHealsOnTeammates, int totalMinionsKilled, int totalTimeCCDealt, int totalTimeSpentDead, int turretKills, int visionScore, int visionWardsBoughtInGame, int wardsKilled, int wardsPlaced, boolean win, Perks perks) {
        this.info = info;
        this.summoner = summoner;
        this.assists = assists;
        this.champLevel = champLevel;
        this.championId = championId;
        this.championName = championName;
        this.championTransform = championTransform;
        this.deaths = deaths;
        this.detectorWardsPlaced = detectorWardsPlaced;
        this.firstBloodKill = firstBloodKill;
        this.firstTowerKill = firstTowerKill;
        this.goldEarned = goldEarned;
        this.item0 = item0;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.kills = kills;
        this.largestCriticalStrike = largestCriticalStrike;
        this.largestKillingSpree = largestKillingSpree;
        this.largestMultiKill = largestMultiKill;
        this.longestTimeSpentLiving = longestTimeSpentLiving;
        this.neutralMinionsKilled = neutralMinionsKilled;
        this.objectiveStolen = objectiveStolen;
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
        this.summoner1Id = summoner1Id;
        this.summoner2Id = summoner2Id;
        this.summonerName = summonerName;
        this.teamId = teamId;
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
        this.totalDamageShieldedOnTeammates = totalDamageShieldedOnTeammates;
        this.totalDamageTaken = totalDamageTaken;
        this.totalHealsOnTeammates = totalHealsOnTeammates;
        this.totalMinionsKilled = totalMinionsKilled;
        this.totalTimeCCDealt = totalTimeCCDealt;
        this.totalTimeSpentDead = totalTimeSpentDead;
        this.turretKills = turretKills;
        this.visionScore = visionScore;
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
        this.wardsKilled = wardsKilled;
        this.wardsPlaced = wardsPlaced;
        this.win = win;
        this.perks = perks;
    }
}
