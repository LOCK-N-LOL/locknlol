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
public class MatchDto {
    private int seasonId;
    private int queueId;
    private Long gameId;
    private List<ParticipantIdentityDto> participantIdentities;
    private String gameVersion;
    private String platformId;
    private String gameMode;
    private int mapId;
    private String gameType;
    private List<TeamStatsDto> teams;
    private List<ParticipantDto> participants;
    private Long gameDuration;
    private Long gameCreation;
}
