package com.gnt.web.dto.match;

import com.gnt.domain.match.Team;
import lombok.Getter;

import java.util.List;

@Getter
public class MatchDto {
    private Long gameDuration;
    private Long gameStartTimestamp;
    private String gameMode;
    private String gameType;
    private int mapId;
    private List<ParticipantDto> participants;
    private Team blueTeam;
    private Team redTeam;
}
