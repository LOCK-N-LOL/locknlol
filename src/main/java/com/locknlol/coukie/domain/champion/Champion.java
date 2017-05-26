package com.locknlol.coukie.domain.champion;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Table(name = "champions")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class Champion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String key;
	public String name;
	public String title;
	public ChampionImage image;
	@ManyToOne
	public List<ChampionTags> tags;
	public String partype;
	public ChampionInfo info;
	@ManyToOne
	public List<ChampionSpell> spells;
	public ChampionPassive passive;
}
