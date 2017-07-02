package com.locknlol.coukie.adapter.riot.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.locknlol.coukie.adapter.riot.dto.EntityConvertable;
import com.locknlol.coukie.domain.champion.entity.Champion;
import com.locknlol.coukie.domain.champion.entity.ChampionImage;
import com.locknlol.coukie.domain.champion.entity.ChampionTags;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionDto implements EntityConvertable<Champion>{
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

	@Override
	public Champion getNewEntity() {
		return new Champion();
	}
}
