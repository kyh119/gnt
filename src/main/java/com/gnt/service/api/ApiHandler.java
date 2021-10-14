package com.gnt.service.api;

import com.gnt.web.dto.summoner.League;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.Summoner;

import java.util.List;

public interface ApiHandler {
    String krUri = "https://kr.api.riotgames.com";
    String asiaUri = "https://asia.api.riotgames.com";
    String apiKey = "RGAPI-8c582859-d9d9-4e1d-bc9b-dd14d3d1560c";

    Summoner getSummonerByName(String summonerName);
    List<League> getLeagueListBySummonerId(String id);
    List<String> getMatchIdListByPuuid(String puuid, int start, int count);
    Match getMatchByMatchId(String matchId);
}
