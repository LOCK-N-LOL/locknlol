package com.locknlol.coukie.domain.champion;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Table(name = "champions")
public class Champion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String key;
	private String name;
	private String title;
	private ChampionImage image;
	//@ManyToOne
	//public List<ChampionTags> tags;
	private String partype;
	private ChampionInfo info;
	@OneToMany
	private List<ChampionSpell> spells;
	private ChampionPassive passive;
}
