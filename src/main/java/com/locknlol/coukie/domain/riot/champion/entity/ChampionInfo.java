package com.locknlol.coukie.domain.riot.champion.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by kev on 2017. 5. 25.
 */
@Entity
@Getter
@Setter
public class ChampionInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long attack;

	private Long defense;

	private Long magic;

	private Long difficulty;

}
