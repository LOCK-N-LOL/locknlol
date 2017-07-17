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
	All_MATCH("/lol/match/v3/matchlists/by-account/{accountId}", "시즌별 모든 랭크 게임 정보"),
	ALL_LEAGUES("/lol/league/v3/leagues/by-summoner/{summonerId}", "리그전 정보"),
	RUNE_PAGES("/lol/platform/v3/runes/by-summoner/{summonerId}", "룬 페이지 정보"),
	//STATIC_DATA_V3_CHAMPION_ALL("/lol/static-data/v3/champions?champListData=all", "모든 챔피언 정보"),
	STATIC_DATA_V3_CHAMPION_ALL("/lol/static-data/v3/champions?locale=ko_KR&tags=image&tags=info&tags=spells&tags=passive&dataById=true", "모든 챔피언 정보"),
	STATIC_DATA_V3_ITEMS("/lol/static-data/v3/items?locale=ko_KR&tags=image", "모든 아이템 정보"),
	//STATIC_DATA_V3_ITEM_BY_ID("/lol/static-data/v3/items/{id}?itemData=all&tags=all", "해당 아이디의 아이템 정보"),
	//STATIC_DATA_V3_SUMMONER_SPELLS("/lol/static-data/v3/summoner-spells?spellListData=all&tags=all", "모든 스펠 정보"),
	STATIC_DATA_V3_SUMMONER_SPELL_BY_ID("/lol/static-data/v3/summoner-spells/{id}?spellData=all&tags=all", "해당 아이디의 스펠 정보");



	private final String url;
	private final String description;
}
