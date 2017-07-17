package com.locknlol.coukie.adapter.riot.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionDto{
	private Long id;
	private String key;
	private String name;
	private String title;
	private ChampionImageDto image;
	private List<String> tags;
	private String partype;
	private ChampionInfoDto info;
	private List<ChampionSpellDto> spells;
	private ChampionPassiveDto passive;

}
