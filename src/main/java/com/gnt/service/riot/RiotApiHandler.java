package com.gnt.service.riot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnt.Constants;
import com.gnt.domain.summoner.League;
import com.gnt.web.dto.match.Match;
import com.gnt.domain.summoner.Summoner;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RiotApiHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String krUri = "https://kr.api.riotgames.com";
    private final String asiaUri = "https://asia.api.riotgames.com";

    private String uri;
    private ObjectMapper mapper;
    public RiotApiHandler() {
        this.mapper = new ObjectMapper();
    }

    private String getJson(String uri) {
        try {
            URL requestUrl = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            String apiKey = Constants.API_KEY;
            connection.setRequestProperty("X-Riot-Token", apiKey);
            int responseCode = connection.getResponseCode();
            switch (responseCode) {
                case 200:
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line = "";
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        return sb.toString();
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                    break;
                case 401:
                    logger.error("API 키 미입력");
                    break;
                case 403:
                    logger.error("API 키 시간 만료");
                    break;
                case 404:
                    logger.error("주소 입력 오류");
                    break;
                case 415:
                    logger.error("Content-Type 오류");
                    break;
                case 429:
                    logger.error("요청 횟수 초과");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("API Request NOT Available");
        }
        return "error";
    }

    public Summoner getSummonerByName(String summonerName) {
        uri = krUri + "/lol/summoner/v4/summoners/by-name/" + summonerName;
        try {
            return mapper.readValue(getJson(uri), Summoner.class);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            logger.error("소환사 정보 파싱 실패");
        }
        return null;
    }

    public List<League> getLeagueListBySummonerId(String id) {
        uri = krUri + "/lol/league/v4/entries/by-summoner/" + id;
        ArrayList<League> leagueList = new ArrayList<>();
        try {
            List<Map<String, Object>> list = mapper.readValue(getJson(uri), new TypeReference<List<Map<String, Object>>>() {
            });
            for (Map<String,Object> map : list) {
                leagueList.add(mapper.readValue(mapper.writeValueAsString(map), League.class));
            }
            return leagueList;
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            logger.error("리그 정보 파싱 실패");
        }
        return null;
    }

    public List<String> getMatchIdListByPuuid(String puuid, int start, int count) {
        uri = asiaUri + "/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=" + start + "&count=" + count;
        try {
            return mapper.readValue(getJson(uri), new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            logger.error("매치 id 파싱 실패");
        }
        return null;
    }

    public Match getMatchByMatchId(String matchId) {
        uri = asiaUri + "/lol/match/v5/matches/" + matchId;
        try {
            return mapper.readValue(getJson(uri), Match.class);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            logger.error("매치 정보 파싱 실패");
        }
        return null;
    }
}
