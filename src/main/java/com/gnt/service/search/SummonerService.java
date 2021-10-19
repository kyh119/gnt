package com.gnt.service.search;

import com.gnt.domain.summoner.SummonerRepository;
import com.gnt.service.riot.RiotApiHandler;
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
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SummonerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RiotApiHandler riotApiHandler;
    private final SummonerRepository summonerRepository;

    public SummonerDto getSummonerByName(String summonerName) {
        try {
            summonerName = URLEncoder.encode(summonerName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.warn(e.getMessage());
            logger.warn("인코딩 오류");
        }
        Summoner summoner = riotApiHandler.getSummonerByName(summonerName);
        try {
            Optional<Summoner> optionalSummoner = summonerRepository.findById(summoner.getPuuid());
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        //summoner.setLeagueList(riotApiHandler.getLeagueListBySummonerId(summoner.getId()));
        return new SummonerDto(summoner);
    }

    public List<Match> getMatchListByName(String summonerName, int start, int count) {
        ArrayList<Match> matchList = new ArrayList<>();
        Summoner summoner = riotApiHandler.getSummonerByName(summonerName);
        List<String> idList = riotApiHandler.getMatchIdListByPuuid(summoner.getPuuid(), start, count);
        for (String id : idList)
            matchList.add(riotApiHandler.getMatchByMatchId(id));
        return matchList;
    }
}
