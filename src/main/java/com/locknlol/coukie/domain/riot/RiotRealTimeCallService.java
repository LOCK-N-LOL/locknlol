package com.locknlol.coukie.domain.riot;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotAdapterParameter;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotRecentMatchesResponse;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;
import com.locknlol.coukie.domain.riot.exception.LoLErrorCode;
import com.locknlol.coukie.domain.riot.summoner.Summoner;
import com.locknlol.coukie.domain.riot.summoner.SummonerFindService;
import com.locknlol.coukie.domain.riot.exception.LoLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Oscar on 2017. 5. 27..
 */
@Slf4j
@Service
public class RiotRealTimeCallService {

	@Autowired
	private RiotAdapter adapter;
	@Autowired
	private SummonerFindService summonerFindService;

	public RiotSummonerByNameResponse findSummonerByName(String summonerName) throws Exception {
		return adapter.get(RiotRequests.SUMMONER_BY_NAME, RiotApiUrl.SUMMONER, RiotAdapterParameter.summonerByName(summonerName));
	}

	public RiotRecentMatchesResponse getRecentMatches(String summonerName) throws Exception {
		Long accountId = getAccountIdBySummonerName(summonerName);
		return adapter.get(RiotRequests.RECENT_MATCHES, RiotApiUrl.RECENT_MATCHES_BY_ACCOUNTID,
			RiotAdapterParameter.recentMatchByAccountId(accountId));
	}

	private Long getAccountIdBySummonerName(String summonerName) throws Exception {
		Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
		if (summonerInfo != null) {
			return summonerInfo.getAccountId();
		}

		return Optional.ofNullable(findSummonerByName(summonerName))
			.map(RiotSummonerByNameResponse::getAccountId)
			.orElseThrow(() -> new LoLException(LoLErrorCode.SUMMONER_NOT_FOUND));
	}

	private Long getSummonerIdBySummonerName(String summonerName) throws Exception {
		Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
		if (summonerInfo != null) {
			return summonerInfo.getId();
		}

		return Optional.ofNullable(findSummonerByName(summonerName))
			.map(RiotSummonerByNameResponse::getSummonerId)
			.orElseThrow(() -> new LoLException(LoLErrorCode.SUMMONER_NOT_FOUND));
	}

	public boolean checkSummonerAuthByRunes(String summonerName) {
		return false;
	}

	public RiotMatchByMatchIdResponse getMatchByMatchId(Long matchId) throws Exception{
		return adapter.get(RiotRequests.MATCH_BY_MATCHID, RiotApiUrl.MATCH_BY_MATCHID, RiotAdapterParameter.matchesByMatchId(matchId));
	}

}
