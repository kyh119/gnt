package com.gnt.service;

import com.gnt.dto.Match;
import com.gnt.dto.Summoner;

import java.util.List;

public interface SearchService {

    Summoner getSummonerByName(String summonerName);

    List<Match> getMatchListByName(String summonerName);
}
