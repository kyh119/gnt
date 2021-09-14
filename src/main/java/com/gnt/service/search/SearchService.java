package com.gnt.service.search;

import com.gnt.web.dto.Match;
import com.gnt.web.dto.Summoner;

import java.util.List;

public interface SearchService {

    Summoner getSummonerByName(String summonerName);

    List<Match> getMatchListByName(String summonerName);
}
