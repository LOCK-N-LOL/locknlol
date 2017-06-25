package com.locknlol.coukie.domain.riot.match.info;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Haylie
 * @since 2017. 6. 26..
 */

@Getter
@Setter
public class PreferredChampionStatDto {
    private Integer championId; //챔피언 Id
    private int wins; // 챔피언 승수
    private int losses; //챔피언 패수
}
