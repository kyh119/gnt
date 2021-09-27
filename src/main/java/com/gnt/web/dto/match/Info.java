package com.gnt.web.dto.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    private Long gameDuration;
    private Long gameStartTimestamp;
    private String gameMode;
    private String gameType;
    private int mapId;
    private List<Participant> participants;
    private List<Team> teams;
}
