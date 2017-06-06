package com.locknlol.coukie.domain.champion.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kev on 2017. 5. 25.
 */
@Entity
@Getter
@Setter
public class Champion {
	@Id
	private Long id;

	@Column(name = "championKey")
	private String key;

	private String name;

	private String title;

	@OneToOne
	private ChampionImage image;

	@OneToMany
	@JoinColumn
	public List<ChampionTags> tags = new ArrayList<>();

	private String partype;

	@OneToOne
	private ChampionInfo info;

	@OneToMany
	@JoinColumn
	private List<ChampionSpell> spells = new ArrayList<>();

	@OneToOne
	private ChampionPassive passive;

}
