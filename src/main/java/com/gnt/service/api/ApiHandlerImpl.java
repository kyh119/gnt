package com.gnt.service.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnt.web.dto.summoner.League;
import com.gnt.web.dto.match.Match;
import com.gnt.web.dto.summoner.Summoner;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ApiHandlerImpl implements ApiHandler {

    private String uri;
    private ObjectMapper mapper;
    public ApiHandlerImpl() {
        this.mapper = new ObjectMapper();
    }

    private String getJson(String uri) {
        try {
            URL requestUrl = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
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
                        // e.printStackTrace();
                    }
                    break;
                case 401:
                    System.out.println("API 키 미입력");
                    break;
                case 403:
                    System.out.println("API 키 시간 만료");
                    break;
                case 404:
                    System.out.println("주소 입력 오류");
                    break;
                case 415:
                    System.out.println("Content-Type 오류");
                    break;
                case 429:
                    System.out.println("요청 횟수 초과");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("소환사 검색 실패");
        }
        return "error";
    }

    @Override
    public Summoner getSummonerByName(String summonerName) {
        uri = krUri + "/lol/summoner/v4/summoners/by-name/" + summonerName;
        try {
            // System.out.println("json : " + getJson(uri));
            return mapper.readValue(getJson(uri), Summoner.class);
        } catch (JsonProcessingException e) {
            // e.printStackTrace();
            System.out.println("소환사 정보 파싱 실패");
        }
        return null;
    }

    @Override
    public List<League> getLeagueListBySummonerId(String id) {
        uri = krUri + "/lol/league/v4/entries/by-summoner/" + id;
        ArrayList<League> leagueList = new ArrayList<>();
        try {
            List<Map<String, Object>> list = mapper.readValue(getJson(uri), new TypeReference<List<Map<String, Object>>>() {
            });
            // System.out.println("final : " + mapper.writeValueAsString(list.get(0)));
            for (Map<String,Object> map : list) {
                leagueList.add(mapper.readValue(mapper.writeValueAsString(map), League.class));
            }
            return leagueList;
        } catch (JsonProcessingException e) {
            // e.printStackTrace();
            System.out.println("리그 정보 파싱 실패");
        }
        return null;
    }

    @Override
    public List<String> getMatchIdListByPuuid(String puuid, int start, int count) {
        uri = asiaUri + "/lol/match/v5/matches/by-puuid/" + puuid + "/ids?start=" + start + "&count=" + count;
        try {
            return mapper.readValue(getJson(uri), new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            System.out.println("매치 id 파싱 실패");
        }
        return null;
    }

    @Override
    public Match getMatchByMatchId(String matchId) {
        uri = asiaUri + "/lol/match/v5/matches/" + matchId;
        try {
            // System.out.println(getJson(uri));
            return mapper.readValue(getJson(uri), Match.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("매치 정보 파싱 실패");
        }
        return null;
    }
}
