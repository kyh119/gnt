package com.gnt.service.api;

import com.gnt.web.dto.League;
import com.gnt.web.dto.Match;
import com.gnt.web.dto.Summoner;

import java.util.List;

public interface ApiHandler {
    String krUri = "https://kr.api.riotgames.com";
    String asiaUri = "https://asia.api.riotgames.com";
    String apiKey = "RGAPI-0259159e-f317-408d-af0b-7da38b544082";

    Summoner getSummonerByName(String summonerName);
    List<League> getLeagueListBySummonerId(String id);
    List<String> getMatchIdListByPuuid(String puuid);
    Match getMatchByMatchId(String matchId);
}
