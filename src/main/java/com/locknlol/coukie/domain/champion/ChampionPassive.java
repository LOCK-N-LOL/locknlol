package com.locknlol.coukie.domain.champion;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Table(name = "champion_passives")
public class ChampionPassive {

	private String name;
	private String description;
	private ChampionPassiveImage image;


}
