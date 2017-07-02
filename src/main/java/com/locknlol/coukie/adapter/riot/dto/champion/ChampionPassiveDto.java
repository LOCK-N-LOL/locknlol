package com.locknlol.coukie.adapter.riot.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.locknlol.coukie.adapter.riot.dto.EntityConvertable;
import com.locknlol.coukie.domain.champion.entity.ChampionPassive;
import lombok.Data;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionPassiveDto implements EntityConvertable<ChampionPassive> {
	private String name;
	private String description;
	private ChampionPassiveImageDto image;

	@Override
	public ChampionPassive getNewEntity() {
		return new ChampionPassive();
	}
}
