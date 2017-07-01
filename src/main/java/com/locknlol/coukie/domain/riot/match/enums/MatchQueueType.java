package com.locknlol.coukie.domain.riot.match.enums;

import lombok.Getter;

/**
 * @author Haylie
 * @since 2017. 7. 1..
 */
public enum MatchQueueType {
    //season 마다 다른것으로 판단됨
    //season8 에서 발견된 값 65, 33, 440, 420, 31

    ALL_RANK,
    SOLO_RANK,
    FREE_RANK,
    NORMAL,
    RANDOM,
    AI,
    USER,
    EVENT;

    @Getter
    private int queueId;
}
