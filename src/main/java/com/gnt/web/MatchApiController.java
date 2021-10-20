package com.gnt.web;

import com.gnt.service.search.MatchService;
import com.gnt.domain.match.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MatchApiController {

    private final MatchService matchService;

    @GetMapping("/api/matches/v1/by-name/{summonerName}")
    public List<Match> getMatchListJsonByName(@PathVariable String summonerName, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "count", defaultValue = "1") int count) {
        return matchService.getMatchListByName(summonerName, start, count);
    }
}
