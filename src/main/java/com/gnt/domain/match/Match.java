package com.gnt.domain.match;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gnt.domain.summoner.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

    private Metadata metadata;
    private Info info;

}
