package com.locknlol.coukie.adapter.riot.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionPassiveDto {
	private Long id;
	private String name;
	private String description;
	private ChampionPassiveImageDto image;


}
