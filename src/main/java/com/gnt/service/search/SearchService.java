package com.gnt.service.search;

import com.gnt.service.api.ApiHandler;
import com.gnt.web.dto.match.Match;
import com.gnt.domain.summoner.Summoner;
import com.gnt.web.dto.summoner.SummonerDto;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApiHandler apiHandler;

    public SummonerDto getSummonerByName(String summonerName) {
        try {
            summonerName = URLEncoder.encode(summonerName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.warn(e.getMessage());
            logger.warn("인코딩 오류");
        }
        Summoner summoner = apiHandler.getSummonerByName(summonerName);
        summoner.setLeagueList(apiHandler.getLeagueListBySummonerId(summoner.getId()));
        return new SummonerDto(summoner);
    }

    public List<Match> getMatchListByName(String summonerName, int start, int count) {
        ArrayList<Match> matchList = new ArrayList<>();
        Summoner summoner = apiHandler.getSummonerByName(summonerName);
        List<String> idList = apiHandler.getMatchIdListByPuuid(summoner.getPuuid(), start, count);
        for (String id : idList)
            matchList.add(apiHandler.getMatchByMatchId(id));
        return matchList;
    }
}
