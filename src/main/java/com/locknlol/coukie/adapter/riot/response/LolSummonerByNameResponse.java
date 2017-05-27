package com.locknlol.coukie.adapter.riot.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Oscar on 2017. 5. 27..
 */
@Getter
@Setter
public class LolSummonerByNameResponse {
	/**
	 * 	ID of the summoner icon associated with the summoner.
	 */
	private Integer profileIconId;
	/**
	 * 소환사 이름
	 */
	private String name;

	private Long summonerLevel;
	/**
	 * 	Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change.
	 */
	private Long revisionDate;
	/**
	 * Summoner ID.
	 */
	private Long id;
	/**
	 * Account ID.
	 */
	private Long accountId;
}
