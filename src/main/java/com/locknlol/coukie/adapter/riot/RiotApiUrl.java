package com.locknlol.coukie.adapter.riot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Oscar on 2017. 5. 25..
 */
@Getter
@AllArgsConstructor
public enum RiotApiUrl {


	SUMMONER("/lol/summoner/v3/summoners/by-name/{summonerName}", "소환사 정보", ApiKey.api_key_mumu),
	RECENT_MATCHES_BY_ACCOUNTID("/lol/match/v3/matchlists/by-account/{accountId}/recent", "최근 20 경기", ApiKey.api_key_mumu),
	MATCH_DETAIL_INFO_BY_MATCHID("/lol/match/v3/matches/{matchId}", "해당 게임의 상세 정보", ApiKey.api_key_mumu);







	private String url;
	private String description;
	private String key;

	public static class ApiKey {
		private static String api_key_mumu ="98930870-11b9-4d43-ad3d-2c629c631a38";
		private static String api_key_kev = "RGAPI-2056f7ec-01fa-4edc-a7d7-d618d663db74";
	}
}
