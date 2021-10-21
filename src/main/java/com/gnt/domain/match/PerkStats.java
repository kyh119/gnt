package com.gnt.domain.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class PerkStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int offense;
    private int defense;
    private int flex;

    @Builder
    public PerkStats(int offense, int defense, int flex) {
        this.offense = offense;
        this.defense = defense;
        this.flex = flex;
    }
}
