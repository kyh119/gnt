package com.gnt.web;

import com.gnt.service.search.SummonerService;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SummonerApiController {
    private final SummonerService summonerService;

    @GetMapping("/api/summoner/v1/by-name/{summonerName}")
    public SummonerDto getSummonerJsonByName(@PathVariable String summonerName) {
        return summonerService.getOrCreateSummonerByName(summonerName);
    }



}
