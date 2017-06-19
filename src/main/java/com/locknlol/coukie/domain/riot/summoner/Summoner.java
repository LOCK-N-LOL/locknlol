package com.locknlol.coukie.domain.riot.summoner;

import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;
import com.locknlol.coukie.domain.common.CommonModel;
import com.locknlol.coukie.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

	@OneToOne
	private User user;

	public static Summoner convert(RiotSummonerByNameResponse response) {
		Summoner summoner = new Summoner();
		summoner.setAccountId(response.getAccountId());
		summoner.setSummonerId(response.getSummonerId());
		summoner.setSummonerName(response.getSummonerName());
		summoner.setCreatedAt(new Date());
		summoner.setCreatedBy("adapter_call");
		return summoner;
	}
}

