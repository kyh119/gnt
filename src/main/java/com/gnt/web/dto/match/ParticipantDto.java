package com.gnt.web.dto.match;

import lombok.Getter;

@Getter
public class ParticipantDto {
    private String summonerName;
    private String championName;
    private int championId;
    private int level;

    private int kill;
    private int assist;
    private int death;
    private Long kda;
    private int killRate;
    private int multiKill;

    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int accessory;

    private int gold;
    private int spell0;
    private int spell1;
    private int deal;
    private int cs;
    private int visionScore;
    private int pinkWard;
    private int wardKill;
    private int ward;

    private boolean win;

    private int stat0;
    private int stat1;
    private int stat2;

    private int mainRune0;
    private int mainRune1;
    private int mainRune2;
    private int mainRune3;
    private int subRune0;
    private int subRune1;
}
