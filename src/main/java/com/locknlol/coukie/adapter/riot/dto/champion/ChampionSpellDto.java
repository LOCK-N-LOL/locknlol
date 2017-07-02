package com.locknlol.coukie.adapter.riot.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.locknlol.coukie.adapter.riot.dto.EntityConvertable;
import com.locknlol.coukie.domain.champion.entity.ChampionSpell;
import lombok.Data;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionSpellDto implements EntityConvertable<ChampionSpell>{
	private String name;
	private String description;
	private ChampionSpellImageDto image;
	private String key;

	@Override
	public ChampionSpell getNewEntity() {
		return new ChampionSpell();
	}
}
