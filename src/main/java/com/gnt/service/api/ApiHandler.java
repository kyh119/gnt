package com.gnt.service.api;

import com.gnt.web.dto.summoner.League;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.Summoner;

import java.util.List;

public interface ApiHandler {
    String krUri = "https://kr.api.riotgames.com";
    String asiaUri = "https://asia.api.riotgames.com";
    String apiKey = "RGAPI-348e10d2-d661-4040-92c0-674b26b2468a";

    Summoner getSummonerByName(String summonerName);
    List<League> getLeagueListBySummonerId(String id);
    List<String> getMatchIdListByPuuid(String puuid, int start, int count);
    Match getMatchByMatchId(String matchId);
}
