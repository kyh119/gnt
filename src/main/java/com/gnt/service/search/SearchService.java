package com.gnt.service.search;

import com.gnt.web.dto.summoner.Summoner;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.SummonerDto;

import java.util.List;

public interface SearchService {
    public SummonerDto getSummonerByName(String summonerName);
    public List<Match> getMatchListByName(String summonerName, int start, int count);
}
