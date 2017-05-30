package com.locknlol.coukie.adapter.riot.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionInfoDto {
	private Long attack;
	private Long defense;
	private Long magic;
	private Long difficulty;
}
