package com.locknlol.coukie.domain.champion;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Table(name = "champion_infos")
public class ChampionInfo {

	public Long attack;
	public Long defense;
	public Long magic;
	public Long difficulty;
}
