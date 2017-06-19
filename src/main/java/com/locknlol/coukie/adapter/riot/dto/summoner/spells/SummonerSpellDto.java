package com.locknlol.coukie.adapter.riot.dto.summoner.spells;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 5.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerSpellDto {
    private List<SpellVarsDto> vars;
//    private Object range;
    private String resource;
    private Integer maxrank;
    private List<String> effectBurn;
    private SummonerSpellImageDto image;
    private List<Double> cooldown;
    private List<Integer> cost;
    private Integer summonerLevel;
    private Integer id;
    private String sanitizedDescription;
    private String costType;
    private String rangeBurn;
//    private Object effect;
    private String cooldownBurn;
    private String description;
    private String name;
    private List<String> modes;
    private String sanitizedTooltip;
    private String key;
    private String costBurn;
    private String tooltip;
}
