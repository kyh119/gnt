package com.gnt.domain.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SUMMONER_ID")
    private Summoner summoner;

    private String queueType;
    private String tier;
    @Column(name = "`rank`")
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean freshBlood;

    @Builder
    public League(Summoner summoner, String queueType, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean freshBlood) {
        this.summoner = summoner;
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.hotStreak = hotStreak;
        this.freshBlood = freshBlood;
    }
}
