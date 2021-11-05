package com.gnt.domain.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PerkStyleSelection {
    private int perk;
    private int var1;
    private int var2;
    private int var3;
}
