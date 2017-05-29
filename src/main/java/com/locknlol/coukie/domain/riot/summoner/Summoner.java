package com.locknlol.coukie.domain.riot.summoner;

import com.locknlol.coukie.domain.common.CommonModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Oscar on 2017. 5. 28..
 */
@Getter
@Setter
@Entity
@Table(name = "summoner")
public class Summoner extends CommonModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "summonerName", updatable = false)
	private String summonerName;

	@Column(name = "accountId", updatable = false)
	private Long accountId;

	@Column(name = "summonerId", updatable = false)
	private Long summonerId;
}

