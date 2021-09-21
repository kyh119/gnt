package com.gnt.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gnt.service.search.SearchService;
import com.gnt.web.dto.Summoner;
import com.gnt.web.dto.match.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/api/get/summoner/by-name/{summonerName}")
    public Summoner getSummonerJsonByName(@PathVariable String summonerName) {
        return searchService.getSummonerByName(summonerName);
    }

    @GetMapping("/api/get/matches/by-name/{summonerName}")
    public List<Match> getMatchListJsonByName(@PathVariable String summonerName, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "count", defaultValue = "1") int count) {
        return searchService.getMatchListByName(summonerName, start, count);
    }

}
