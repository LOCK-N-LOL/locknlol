package com.locknlol.coukie.controller.riot;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.response.LolRecentMatchesResponse;
import com.locknlol.coukie.adapter.riot.response.LolSummonerByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oscar on 2017. 5. 27..
 */
@Service
public class RiotRealTimeService {

	@Autowired
	private RiotAdapter adapter;

	public LolSummonerByNameResponse findSummonerByName(String summonerName) throws Exception {
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("summonerName", summonerName);
		return adapter.get(RiotRequests.SUMMONER_BY_NAME, RiotApiUrl.SUMMONER, requestParam);
	}

	public LolRecentMatchesResponse getRecentMatches(String summonerName) throws Exception {
		Long accountId = getAccountIdBySummonerName(summonerName);
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("accountId", accountId);
		return adapter.get(RiotRequests.RECENT_MATCHES, RiotApiUrl.RECENT_MATCHES_BY_ACCOUNTID, requestParam);
	}

	private Long getAccountIdBySummonerName(String summonerName) throws Exception {
		LolSummonerByNameResponse response = findSummonerByName(summonerName);
		Assert.notNull(response);

		return response.getAccountId();
	}
}
