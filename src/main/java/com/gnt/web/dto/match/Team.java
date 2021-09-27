package com.gnt.web.dto.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private List<Ban> bans;
    private Objectives objectives;
    private int teamId;
    private boolean win;
}
