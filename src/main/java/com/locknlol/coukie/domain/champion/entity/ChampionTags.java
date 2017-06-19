package com.locknlol.coukie.domain.champion.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by kev on 2017. 5. 25.
 */
@Entity
@Getter
@Setter
public class ChampionTags {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
}
