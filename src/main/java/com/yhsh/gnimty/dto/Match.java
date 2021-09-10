package com.yhsh.gnimty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Match {
    @JsonProperty
    private Metadata metadata;

    @JsonProperty
    private Info info;

    private String gameMode;

}
