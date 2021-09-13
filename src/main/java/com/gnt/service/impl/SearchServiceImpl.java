package com.gnt.service.impl;

import com.gnt.dto.Match;
import com.gnt.dto.Summoner;
import com.gnt.service.SearchService;
import com.gnt.service.api.ApiHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private ApiHandler apiHandler;

    public SearchServiceImpl(ApiHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    @Override
    public Summoner getSummonerByName(String summonerName) {
        Summoner summoner = apiHandler.getSummonerByName(summonerName);
        // System.out.println(summoner.getId());
        summoner.setLeagueList(apiHandler.getLeagueListBySummonerId(summoner.getId()));
        return summoner;
    }

    @Override
    public List<Match> getMatchListByName(String summonerName) {
        ArrayList<Match> matchList = new ArrayList<>();
        Summoner summoner = apiHandler.getSummonerByName(summonerName);
        List<String> idList = apiHandler.getMatchIdListByPuuid(summoner.getPuuid());
        for (String id : idList)
            matchList.add(apiHandler.getMatchByMatchId(id));
        return matchList;
    }
}
