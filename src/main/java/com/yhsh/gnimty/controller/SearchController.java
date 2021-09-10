package com.yhsh.gnimty.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhsh.gnimty.dto.Summoner;
import com.yhsh.gnimty.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private SearchService searchService;
    private ObjectMapper mapper;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
        this.mapper = new ObjectMapper();
    }

    @GetMapping("/api/get/summoner/by-name/{summonerName}")
    public String getSummonerJsonByName(@PathVariable String summonerName) throws JsonProcessingException {
        Summoner summoner = searchService.getSummonerByName(summonerName);
        return mapper.writeValueAsString(summoner);
    }

    @GetMapping("/api/get/matches/by-name/{summonerName}")
    public String getMatchListJsonByName(@PathVariable String summonerName) throws JsonProcessingException {
        return mapper.writeValueAsString(searchService.getMatchListByName(summonerName));
    }

}
