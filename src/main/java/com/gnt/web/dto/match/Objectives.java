package com.gnt.web.dto.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
