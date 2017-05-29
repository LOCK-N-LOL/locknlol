package com.locknlol.coukie.adapter.riot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Haylie
 * @since 2017. 5. 29..
 */

@Getter
@Setter
public class ParticipantTimelineDto {
    private String lane;
    private int participantId;
    private Map<String, Double> csDiffPerMinDeltas;
    private Map<String, Double> goldPerMinDeltas;
    private Map<String, Double> xpDiffPerMinDeltas;
    private Map<String, Double> creepsPerMinDeltas;
    private Map<String, Double> xpPerMinDeltas;
    private String role;
    private Map<String, Double> damageTakenDiffPerMinDeltas;
    private Map<String, Double> damageTakenPerMinDeltas;

}
