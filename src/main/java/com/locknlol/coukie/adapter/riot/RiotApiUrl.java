package com.locknlol.coukie.adapter.riot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Oscar on 2017. 5. 25..
 */
@Getter
@AllArgsConstructor
public enum RiotApiUrl {

	SUMMONER("/lol/summoner/v3/summoners/by-name/{summonerName}", "소환사 정보"),
	RECENT_MATCHES_BY_ACCOUNTID("/lol/match/v3/matchlists/by-account/{accountId}/recent", "최근 20 경기"),
	MATCH_BY_MATCHID("/lol/match/v3/matches/{matchId}", "해당 게임의 상세 정보"),
	All_MATCH("/lol/match/v3/matchlists/by-account/{accountId}", "시즌별 모든 랭크 게임 정보");

	private final String url;
	private final String description;
}
