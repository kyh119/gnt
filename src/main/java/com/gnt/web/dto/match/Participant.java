package com.gnt.web.dto.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant {
    private String summonerName;
    private String championName;
    private int championId;
    private int champLevel;
    private int kills;
    private int assists;
    private int deaths;
    private int largestMultiKill;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int goldEarned;
    private int summoner1Id;
    private int summoner2Id;
    private int teamId;
    private int totalDamageDealtToChampions;
    private int totalMinionsKilled;
    private int visionScore;
    private int visionWardsBoughtInGame;
    private int wardsKilled;
    private int wardsPlaced;
    private boolean win;

    private Perks perks;

}
