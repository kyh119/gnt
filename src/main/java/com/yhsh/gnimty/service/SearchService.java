package com.yhsh.gnimty.service;

import com.yhsh.gnimty.dto.Match;
import com.yhsh.gnimty.dto.Summoner;

import java.util.List;

public interface SearchService {

    Summoner getSummonerByName(String summonerName);

    List<Match> getMatchListByName(String summonerName);
}
