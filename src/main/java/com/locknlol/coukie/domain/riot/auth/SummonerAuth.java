package com.locknlol.coukie.domain.riot.auth;

import com.locknlol.coukie.domain.common.CommonModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@Getter
@Setter
@Entity
@Table(name = "summoner_auth")
public class SummonerAuth extends CommonModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "auth_key", nullable = false)
	private String authKey;

	@Column(name = "summoner_name", nullable = false, updatable = false)
	private String summonerName;

	@Column(name = "complete")
	private Boolean complete = false;
}
