package com.locknlol.coukie.adapter.riot;

import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemListDto;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellDto;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellListDto;
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
}
