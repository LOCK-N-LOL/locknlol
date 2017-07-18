package com.locknlol.coukie.adapter.riot.dto.champion;

import com.locknlol.coukie.adapter.riot.dto.ImageDto;
import com.locknlol.coukie.domain.champion.entity.ChampionImage;
import lombok.Data;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
public class ChampionImageDto extends ImageDto<ChampionImage> {

	@Override
	public ChampionImage getNewEntity() {
		return new ChampionImage();
	}

	@Override
	public String getFull() {
		return "champion/" + super.getFull();
	}
}
