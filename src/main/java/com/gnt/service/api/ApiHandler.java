package com.gnt.service.api;

import com.gnt.web.dto.summoner.League;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.Summoner;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface ApiHandler {
    String krUri = "https://kr.api.riotgames.com";
    String asiaUri = "https://asia.api.riotgames.com";

    Summoner getSummonerByName(String summonerName);
    List<League> getLeagueListBySummonerId(String id);
    List<String> getMatchIdListByPuuid(String puuid, int start, int count);
    Match getMatchByMatchId(String matchId);
}
