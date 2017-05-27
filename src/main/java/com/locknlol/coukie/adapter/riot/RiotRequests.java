package com.locknlol.coukie.adapter.riot;

import com.locknlol.coukie.adapter.riot.response.LolRecentMatchesResponse;
import com.locknlol.coukie.adapter.riot.response.LolSummonerByNameResponse;

/**
 * Created by Oscar on 2017. 5. 27..
 */
public class RiotRequests {

	public static final RiotRequest<LolSummonerByNameResponse> SUMMONER_BY_NAME = RiotRequest.of(LolSummonerByNameResponse.class);
	public static final RiotRequest<LolRecentMatchesResponse> RECENT_MATCHES = RiotRequest.of(LolRecentMatchesResponse.class);
}
