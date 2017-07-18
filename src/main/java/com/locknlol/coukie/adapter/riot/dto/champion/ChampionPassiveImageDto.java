package com.locknlol.coukie.adapter.riot.dto.champion;

import com.locknlol.coukie.adapter.riot.dto.ImageDto;
import com.locknlol.coukie.domain.champion.entity.ChampionPassiveImage;
import lombok.Data;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
public class ChampionPassiveImageDto extends ImageDto {

	@Override
	public ChampionPassiveImage getNewEntity() {
		return new ChampionPassiveImage();
	}

	@Override
	public String getFull() {
		return "passive/" + super.getFull();
	}
}
