package com.redhat.hackathon;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public record Bulletpoints(List<String> items) {
    @JsonCreator
    public Bulletpoints {
    }
}
