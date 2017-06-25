package com.locknlol.coukie.domain.riot.match.info;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Haylie
 * @since 2017. 6. 26..
 */

@Getter
@Setter
public class PreferredPositionStatDto {
    private int positionType; //포지션 타입
    private int frequencyStat; //픽률
    private int wins; //포지션별 승수
    private int losses; //포지션별 패수

}
