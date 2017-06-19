package com.locknlol.coukie.adapter.riot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Haylie
 * @since 2017. 5. 29..
 */
@Getter
@Setter
public class ParticipantDto {
    private ParticipantStatsDto stats;
    private Integer participantId;
    private List<RuneDto> runes;
    private ParticipantTimelineDto timeline;
    private Integer teamId;
    private Integer spell2Id;
    private List<MasteryDto> masteries;
    private String highestAchievedSeasonTier;
    private Integer spell1Id;
    private Integer championId;
}
