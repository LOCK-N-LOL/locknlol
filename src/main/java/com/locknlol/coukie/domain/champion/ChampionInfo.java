package com.locknlol.coukie.domain.champion;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Table(name = "champion_infos")
public class ChampionInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long attack;
	private Long defense;
	private Long magic;
	private Long difficulty;
}
