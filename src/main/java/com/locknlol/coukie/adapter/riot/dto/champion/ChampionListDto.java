package com.locknlol.coukie.adapter.riot.dto.champion;

import lombok.Data;

import java.util.Map;

/**
 * @author jinie@coupang.com
 * @since 2017. 5. 29.
 */
@Data
public class ChampionListDto {
    private Map<String, String> keys;
    private Map<String, ChampionDto> data;
    private String version;
    private String type;
    private String format;
}
