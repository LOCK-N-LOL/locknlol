package com.locknlol.coukie.domain.riot;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotAdapterParameter;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.response.RiotLeaguesBySummonerIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchResponse;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 6. 4..
 */
@Service
public class RiotAdapterService {

	@Autowired
	private RiotAdapter riotAdapter;


	public RiotSummonerByNameResponse getSummonerByName(String summonerName) {
		return riotAdapter.get(RiotRequests.SUMMONER_BY_NAME, RiotAdapterParameter.summonerByName(summonerName));
	}

	public RiotMatchResponse getRecentMatchesByAccountId(Long accountId) {
		return riotAdapter.get(RiotRequests.RECENT_MATCHES, RiotAdapterParameter.recentMatchByAccountId(accountId));
	}

	public RiotMatchByMatchIdResponse getMatchByMatchId(Long matchId) {
		return riotAdapter.get(RiotRequests.MATCH_BY_MATCHID, RiotAdapterParameter.matchesByMatchId(matchId));
	}

	public RiotMatchResponse getAllMatches(Long accountId) {
		return riotAdapter.get(RiotRequests.All_MATCHES, RiotAdapterParameter.AllMatchsByAccountId(accountId));
	}

	public RiotLeaguesBySummonerIdResponse getAllLeaguesBySummonerId(Long summonerId) {
		return riotAdapter.get(RiotRequests.ALL_LEAGUES, RiotAdapterParameter.AllMatchsByAccountId(summonerId));
	}
}
