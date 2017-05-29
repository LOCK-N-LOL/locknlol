package com.locknlol.coukie.domain.champion;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by kev on 2017. 5. 25.
 */
public class ChampionPassive {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private ChampionPassiveImage image;


}
