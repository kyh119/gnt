package com.gnt.service.search;

import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.Summoner;
import com.gnt.service.api.ApiHandler;
import com.gnt.web.dto.summoner.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private final ApiHandler apiHandler;

    @Override
    public SummonerDto getSummonerByName(String summonerName) {
        try {
            summonerName = URLEncoder.encode(summonerName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("인코딩 오류");
        }
        Summoner summoner = apiHandler.getSummonerByName(summonerName);
        // System.out.println(summoner.getId());
        summoner.setLeagueList(apiHandler.getLeagueListBySummonerId(summoner.getId()));
        return new SummonerDto(summoner);
    }

    @Override
    public List<Match> getMatchListByName(String summonerName, int start, int count) {
        ArrayList<Match> matchList = new ArrayList<>();
        Summoner summoner = apiHandler.getSummonerByName(summonerName);
        List<String> idList = apiHandler.getMatchIdListByPuuid(summoner.getPuuid(), start, count);
        for (String id : idList)
            matchList.add(apiHandler.getMatchByMatchId(id));
        return matchList;
    }
}
