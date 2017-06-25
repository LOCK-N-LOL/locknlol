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
    //랭크 타입
    static final int ALL_RANK = 0;
    static final int SOLO_RANK = 1;
    static final int FREE_RANK = 2;

    //큐 타입
    static final int NORMAL_QUEUE = 100;
    static final int RANDOM_QUEUE = 101;
    static final int AI_QUEUE = 102;
    static final int USER_QUEUE = 103;
    static final int EVENT_QUEUE = 104;

    //공통 정보
    private int wins;
    private int loses;
    private int kills;
    private int deaths;
    private int assists;
    private List<PreferredChampionStatDto> preferredChampionStatList; //선호 챔피언 통계 리스트
    private List<PreferredPositionStatDto> preferredPositionStatDtoList; //선호 포지션 통계 리스트

}
