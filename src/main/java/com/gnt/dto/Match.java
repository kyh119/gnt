package com.gnt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Match {

    @JsonProperty
    private Metadata metadata;

    @JsonProperty
    private Info info;

    private String gameMode;

    public Match() {
    }

    public Metadata getMetadata() {
        return metadata;
    }


    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Info getInfo() {
        return info;
    }


    public void setInfo(Info info) {
        this.info = info;
    }
}
