package com.locknlol.coukie.adapter.riot.dto.champion;

import com.locknlol.coukie.adapter.riot.dto.ImageDto;
import com.locknlol.coukie.domain.riot.champion.entity.ChampionSpellImage;
import lombok.Data;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
public class ChampionSpellImageDto extends ImageDto{
	@Override
	public ChampionSpellImage getNewEntity() {
		return new ChampionSpellImage();
	}

	@Override
	public String getFull() {
		return "spell/" + super.getFull();
	}
}
