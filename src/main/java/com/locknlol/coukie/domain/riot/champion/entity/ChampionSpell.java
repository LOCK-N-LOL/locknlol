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
public class ChampionSpell {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Lob
	private String description;

	@OneToOne
	private ChampionSpellImage image;

	@Column(name = "championSpellKey")
	private String key;


}
