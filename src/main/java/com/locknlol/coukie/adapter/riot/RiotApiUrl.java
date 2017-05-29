package com.locknlol.coukie.adapter.riot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Oscar on 2017. 5. 25..
 */
@Getter
@AllArgsConstructor
public enum RiotApiUrl {

	SUMMONER("/lol/summoner/v3/summoners/by-name/{summonerName}", "소환사 정보", ApiKey.API_KEY_MUMU),
	RECENT_MATCHES_BY_ACCOUNTID("/lol/match/v3/matchlists/by-account/{accountId}/recent", "최근 20 경기", ApiKey.API_KEY_KEV),
	MATCH_DETAIL_INFO_BY_MATCH_ID("/lol/match/v3/matches/{matchId}", "해당 게임의 상세 정보", ApiKey.API_KEY_JBAM),
	STATIC_DATA_V3_CHAMPION_ALL("lol/static-data/v3/champions?champListData=all", "모든 챔피언 정보", ApiKey.API_KEY_KEV),
	STATIC_DATA_V3_CHAMPION_BY_ID("lol/static-data/v3/champions/{id}?champListData=all", "해당 아이디의 챔피언 정보", ApiKey.API_KEY_KEV);

	private final String url;
	private final String description;
	private final String key;

	public static class ApiKey {
		private static final String API_KEY_MUMU = "98930870-11b9-4d43-ad3d-2c629c631a38";
		private static final String API_KEY_KEV = "RGAPI-2056f7ec-01fa-4edc-a7d7-d618d663db74";
		private static final String API_KEY_JBAM = "RGAPI-57969e80-fe51-4674-bfc7-14c0cdd69617";
	}
}
