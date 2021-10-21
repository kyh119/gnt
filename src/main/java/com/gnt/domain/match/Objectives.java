package com.gnt.domain.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Objectives {
    private Objective baron;
    private Objective champion;
    private Objective dragon;
    private Objective inhibitor;
    private Objective riftHerald;
    private Objective tower;
}
