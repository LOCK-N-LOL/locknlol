package com.locknlol.coukie.adapter.riot.dto.summoner.spells;

import lombok.Data;

import java.util.Map;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 5.
 */
@Data
public class SummonerSpellListDto {
    private Map<String, SummonerSpellDto> data;
    private String type;
    private String version;

}
