package com.locknlol.coukie.adapter.riot;

import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemListDto;
import com.locknlol.coukie.adapter.riot.dto.rune.RiotRunePagesResponse;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellDto;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellListDto;
import com.locknlol.coukie.adapter.riot.response.RiotLeaguesBySummonerIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchResponse;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;

/**
 * Created by Oscar on 2017. 5. 27..
 */
public class RiotRequests {

	public static final RiotRequest<ChampionListDto> CHAMPOIONS = RiotRequest.of(RiotApiUrl.STATIC_DATA_V3_CHAMPION_ALL, ChampionListDto.class);
	public static final RiotRequest<ChampionDto> CHAMPOION_BY_ID = RiotRequest.of(RiotApiUrl.STATIC_DATA_V3_CHAMPION_BY_ID, ChampionDto.class);
	public static final RiotRequest<ItemListDto> ITEMS = RiotRequest.of(RiotApiUrl.STATIC_DATA_V3_ITEMS, ItemListDto.class);
	public static final RiotRequest<ItemDto> ITEM_BY_ID = RiotRequest.of(RiotApiUrl.STATIC_DATA_V3_ITEM_BY_ID, ItemDto.class);
	public static final RiotRequest<SummonerSpellListDto> SUMMONER_SPELLS = RiotRequest.of(RiotApiUrl.STATIC_DATA_V3_SUMMONER_SPELLS, SummonerSpellListDto.class);
	public static final RiotRequest<SummonerSpellDto> SUMMONER_SPELL_BY_ID = RiotRequest.of(RiotApiUrl.STATIC_DATA_V3_SUMMONER_SPELL_BY_ID, SummonerSpellDto.class);
	public static final RiotRequest<RiotSummonerByNameResponse> SUMMONER_BY_NAME = RiotRequest.of(RiotApiUrl.SUMMONER, RiotSummonerByNameResponse.class);
	public static final RiotRequest<RiotMatchResponse> RECENT_MATCHES = RiotRequest.of(RiotApiUrl.RECENT_MATCHES_BY_ACCOUNTID, RiotMatchResponse.class);
	public static final RiotRequest<RiotMatchByMatchIdResponse> MATCH_BY_MATCH_ID = RiotRequest.of(RiotApiUrl.MATCH_BY_MATCHID, RiotMatchByMatchIdResponse.class);
	public static final RiotRequest<RiotMatchResponse> All_MATCHES = RiotRequest.of(RiotApiUrl.All_MATCH, RiotMatchResponse.class);
	public static final RiotRequest<RiotLeaguesBySummonerIdResponse> ALL_LEAGUES = RiotRequest.of(RiotApiUrl.ALL_LEAGUES, RiotLeaguesBySummonerIdResponse.class);
	public static final RiotRequest<RiotRunePagesResponse> RUNE_PAGES = RiotRequest.of(RiotApiUrl.RUNE_PAGES, RiotRunePagesResponse.class);
}
