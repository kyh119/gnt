package com.gnt.domain.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Info {
    @Id
    private String matchId;

    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private String gameVersion;
    private int mapId;
    private int queueId;

    @OneToMany(mappedBy = "info")
    private List<Participant> participants;

    @Builder
    public Info(String matchId, Long gameCreation, Long gameDuration, String gameMode, String gameVersion, int mapId, int queueId) {
        this.matchId = matchId;
        this.gameCreation = gameCreation;
        this.gameDuration = gameDuration;
        this.gameMode = gameMode;
        this.gameVersion = gameVersion;
        this.mapId = mapId;
        this.queueId = queueId;
    }
}
