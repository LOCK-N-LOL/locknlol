package com.locknlol.coukie.adapter.riot.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.locknlol.coukie.adapter.riot.dto.EntityConvertable;
import com.locknlol.coukie.domain.champion.entity.ChampionInfo;
import lombok.Data;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionInfoDto implements EntityConvertable<ChampionInfo> {
	private Long attack;
	private Long defense;
	private Long magic;
	private Long difficulty;

	@Override
	public ChampionInfo getNewEntity() {
		return new ChampionInfo();
	}
}
