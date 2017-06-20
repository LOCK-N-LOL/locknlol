package com.locknlol.coukie.adapter.riot.dto;

import com.locknlol.coukie.adapter.riot.dto.ParticipantDto;
import com.locknlol.coukie.adapter.riot.dto.ParticipantIdentityDto;
import com.locknlol.coukie.adapter.riot.dto.TeamStatsDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Haylie
 * @since 2017. 5. 29..
 */

@Getter
@Setter
public class RiotMatchByMatchIdDto {
    private Integer seasonId;
    private Integer queueId;
    private Long gameId;
    private List<ParticipantIdentityDto> participantIdentities;
    private String gameVersion;
    private String platformId;
    private String gameMode;
    private Integer mapId;
    private String gameType;
    private List<TeamStatsDto> teams;
    private List<ParticipantDto> participants;
    private Long gameDuration;
    private Long gameCreation;
}
