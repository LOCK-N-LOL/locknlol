package com.locknlol.coukie.adapter.riot;

import com.locknlol.coukie.adapter.riot.response.LolRecentMatchesResponse;
import com.locknlol.coukie.adapter.riot.response.LolSummonerByNameResponse;

/**
 * Created by Oscar on 2017. 5. 27..
 */
public class RiotRequests {

	public static final RiotRequest<LolSummonerByNameResponse> SUMMONER_BY_NAME = RiotRequest.of(LolSummonerByNameResponse.class);
	public static final RiotRequest<LolRecentMatchesResponse> RECENT_MATCHES = RiotRequest.of(LolRecentMatchesResponse.class);
	public static final RiotRequest<ChampionListDto> CHAMPOIONS = RiotRequest.of(ChampionListDto.class);
	public static final RiotRequest<ChampionDto> CHAMPOION_BY_ID = RiotRequest.of(ChampionDto.class);
	public static final RiotRequest<ItemListDto> ITEMS = RiotRequest.of(ItemListDto.class);
	public static final RiotRequest<ItemDto> ITEM_BY_ID = RiotRequest.of(ItemDto.class);
	public static final RiotRequest<SummonerSpellListDto> SUMMONER_SPELLS = RiotRequest.of(SummonerSpellListDto.class);
	public static final RiotRequest<SummonerSpellDto> SUMMONER_SPELL_BY_ID = RiotRequest.of(SummonerSpellDto.class);
	public static final RiotRequest<RiotSummonerByNameResponse> SUMMONER_BY_NAME = RiotRequest.of(RiotApiUrl.SUMMONER, RiotSummonerByNameResponse.class);
	public static final RiotRequest<RiotMatchResponse> RECENT_MATCHES = RiotRequest.of(RiotApiUrl.RECENT_MATCHES_BY_ACCOUNTID, RiotMatchResponse.class);
	public static final RiotRequest<RiotMatchByMatchIdResponse> MATCH_BY_MATCH_ID = RiotRequest.of(RiotApiUrl.MATCH_BY_MATCHID, RiotMatchByMatchIdResponse.class);
	public static final RiotRequest<RiotMatchResponse> All_MATCHES = RiotRequest.of(RiotApiUrl.All_MATCH, RiotMatchResponse.class);
	public static final RiotRequest<RiotLeaguesBySummonerIdResponse> ALL_LEAGUES = RiotRequest.of(RiotApiUrl.ALL_LEAGUES, RiotLeaguesBySummonerIdResponse.class);
	public static final RiotRequest<RiotRunePagesResponse> RUNE_PAGES = RiotRequest.of(RiotApiUrl.RUNE_PAGES, RiotRunePagesResponse.class);
}
