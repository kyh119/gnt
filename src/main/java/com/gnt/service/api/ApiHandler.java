package com.gnt.service.api;

import com.gnt.web.dto.League;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.Summoner;

import java.util.List;

public interface ApiHandler {
    String krUri = "https://kr.api.riotgames.com";
    String asiaUri = "https://asia.api.riotgames.com";
    String apiKey = "RGAPI-f800a5f0-106e-49f7-b27d-33938b44d996";

    Summoner getSummonerByName(String summonerName);
    List<League> getLeagueListBySummonerId(String id);
    List<String> getMatchIdListByPuuid(String puuid, int start, int count);
    Match getMatchByMatchId(String matchId);
}
