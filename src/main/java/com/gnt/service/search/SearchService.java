package com.gnt.service.search;

import com.gnt.web.dto.Summoner;
import com.gnt.web.dto.match.Match;

import java.util.List;

public interface SearchService {
    public Summoner getSummonerByName(String summonerName);
    public List<Match> getMatchListByName(String summonerName, int start, int count);
}
