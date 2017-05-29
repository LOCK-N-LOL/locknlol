package com.locknlol.coukie.adapter.riot;

import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotRecentMatchesResponse;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;

/**
 * Created by Oscar on 2017. 5. 27..
 */
public class RiotRequests {

	public static final RiotRequest<RiotSummonerByNameResponse> SUMMONER_BY_NAME = RiotRequest.of(RiotSummonerByNameResponse.class);
	public static final RiotRequest<RiotRecentMatchesResponse> RECENT_MATCHES = RiotRequest.of(RiotRecentMatchesResponse.class);
	public static final RiotRequest<RiotMatchByMatchIdResponse> MATCH_BY_MATCHID = RiotRequest.of(RiotMatchByMatchIdResponse.class);
}
