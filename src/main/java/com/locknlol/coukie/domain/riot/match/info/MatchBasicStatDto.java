package com.locknlol.coukie.domain.riot.match.info;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Haylie
 * @since 2017. 6. 26..
 */

@Getter
@Setter
public class MatchBasicStatDto {
    //공통 정보
    private int wins;
    private int loses;
    private int kills;
    private int deaths;
    private int assists;
    private int winningAvg;
    private int killingParticipationAvg;
    private List<PreferredChampionStatDto> preferredChampionStatList; //선호 챔피언 통계 리스트
    private List<PreferredPositionStatDto> preferredPositionStatDtoList; //선호 포지션 통계 리스트

}
