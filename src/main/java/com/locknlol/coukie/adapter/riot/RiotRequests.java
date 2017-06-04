package com.locknlol.coukie.adapter.riot;

import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchResponse;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;

/**
 * Created by Oscar on 2017. 5. 27..
 */
public class RiotRequests {

	public static final RiotRequest<RiotSummonerByNameResponse> SUMMONER_BY_NAME = RiotRequest.of(RiotApiUrl.SUMMONER, RiotSummonerByNameResponse.class);
	public static final RiotRequest<RiotMatchResponse> RECENT_MATCHES = RiotRequest.of(RiotApiUrl.RECENT_MATCHES_BY_ACCOUNTID, RiotMatchResponse.class);
	public static final RiotRequest<RiotMatchByMatchIdResponse> MATCH_BY_MATCHID = RiotRequest.of(RiotApiUrl.MATCH_BY_MATCHID, RiotMatchByMatchIdResponse.class);
	public static final RiotRequest<RiotMatchResponse> All_MATCHES = RiotRequest.of(RiotApiUrl.All_MATCH, RiotMatchResponse.class);
}
