package com.gnt.service.api;

import com.gnt.web.dto.summoner.League;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.Summoner;

import java.util.List;

public interface ApiHandler {
    String krUri = "https://kr.api.riotgames.com";
    String asiaUri = "https://asia.api.riotgames.com";
    String apiKey = "RGAPI-c74a3413-3081-4a99-9668-f70a635bc7f3";

    Summoner getSummonerByName(String summonerName);
    List<League> getLeagueListBySummonerId(String id);
    List<String> getMatchIdListByPuuid(String puuid, int start, int count);
    Match getMatchByMatchId(String matchId);
}
