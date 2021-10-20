package com.gnt.service.search;

import com.gnt.domain.summoner.League;
import com.gnt.domain.summoner.LeagueRepository;
import com.gnt.domain.summoner.SummonerRepository;
import com.gnt.service.riot.RiotApiHandler;
import com.gnt.web.dto.match.Match;
import com.gnt.domain.summoner.Summoner;
import com.gnt.web.dto.summoner.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SummonerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RiotApiHandler riotApiHandler;
    private final SummonerRepository summonerRepository;
    private final LeagueRepository leagueRepository;

    public SummonerDto getOrCreateSummonerByName(String summonerName) {
        try {
            summonerName = URLEncoder.encode(summonerName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.warn(e.getMessage());
            logger.warn("인코딩 오류");
        }
        Summoner summoner = riotApiHandler.getSummonerByName(summonerName);

        return new SummonerDto(
                summonerRepository.findById(summoner.getId())
                        .orElseGet(() -> createNewSummoner(summoner))
        );
    }

    private Summoner createNewSummoner(Summoner summoner) {

        logger.debug("create new summoner");

        List<League> leagueList = riotApiHandler.getLeagueListBySummonerId(summoner.getId());
        for (League league : leagueList) {
            leagueRepository.save(League.builder()
                    .queueType(league.getQueueType())
                    .tier(league.getTier())
                    .rank(league.getRank())
                    .leaguePoints(league.getLeaguePoints())
                    .wins(league.getWins())
                    .losses(league.getLosses())
                    .hotStreak(league.isHotStreak())
                    .summoner(summonerRepository.save(summoner))
                    .freshBlood(league.isFreshBlood())
                    .build());
        }
        return Summoner.builder()
                .id(summoner.getId())
                .name(summoner.getName())
                .accountId(summoner.getAccountId())
                .profileIconId(summoner.getProfileIconId())
                .revisionDate(summoner.getRevisionDate())
                .puuid(summoner.getPuuid())
                .summonerLevel(summoner.getSummonerLevel())
                .leagueList(leagueList)
                .build();
    }


}
