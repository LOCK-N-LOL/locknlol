package com.locknlol.coukie.domain.riot;

import com.locknlol.coukie.adapter.riot.dto.rune.RiotRunePagesResponse;
import com.locknlol.coukie.adapter.riot.response.RiotLeaguesBySummonerIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchResponse;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;
import com.locknlol.coukie.domain.riot.exception.RiotErrorCode;
import com.locknlol.coukie.domain.riot.exception.RiotException;
import com.locknlol.coukie.domain.riot.summoner.Summoner;
import com.locknlol.coukie.domain.riot.summoner.SummonerFindService;
import com.locknlol.coukie.domain.riot.summoner.SummonerSaveService;
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
	private RiotAdapterService riotAdapterService;
	@Autowired
	private SummonerFindService summonerFindService;
	@Autowired
	private SummonerSaveService summonerSaveService;

	public RiotSummonerByNameResponse getSummonerByName(String summonerName) {
		return riotAdapterService.getSummonerByName(summonerName);
	}

	public RiotMatchResponse getRecentMatches(String summonerName) {
		Long accountId = getAccountIdBySummonerName(summonerName);
		return riotAdapterService.getRecentMatchesByAccountId(accountId);
	}

	public RiotMatchByMatchIdResponse getMatchByMatchId(Long matchId) {
		return riotAdapterService.getMatchByMatchId(matchId);
	}

	public RiotLeaguesBySummonerIdResponse getLeaguesBySummonerId(Long summonerId) {
		return riotAdapterService.getAllLeaguesBySummonerId(summonerId);
	}

	private Long getSummonerIdBySummonerName(String summonerName) {
		Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
		if (summonerInfo != null) {
			return summonerInfo.getSummonerId();
		}

		RiotSummonerByNameResponse response = getSummonerByName(summonerName);
		saveSummoner(response);

		return Optional.ofNullable(response)
			.map(RiotSummonerByNameResponse::getSummonerId)
			.orElseThrow(() -> new RiotException(RiotErrorCode.SUMMONER_NOT_FOUND));
	}

	public boolean checkSummonerAuthByRunes(String summonerName) {
		return false;
	}

	public RiotMatchResponse getAllMatches(String summonerName) {
		Long accountId = getAccountIdBySummonerName(summonerName);
		return riotAdapterService.getAllMatches(accountId);
	}

	private Long getAccountIdBySummonerName(String summonerName) {
		Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
		if (summonerInfo != null) {
			return summonerInfo.getAccountId();
		}

		RiotSummonerByNameResponse response = getSummonerByName(summonerName);
		saveSummoner(response);

		return Optional.ofNullable(getSummonerByName(summonerName))
			.map(RiotSummonerByNameResponse::getAccountId)
			.orElseThrow(() -> new RiotException(RiotErrorCode.SUMMONER_NOT_FOUND));
	}

	private void saveSummoner(RiotSummonerByNameResponse response) {
		Optional.of(response)
			.ifPresent(res -> summonerSaveService.save(res));
	}

	public RiotRunePagesResponse getRunePagesDetailInfo(String summonerName) {
		Long summonerId = getSummonerIdBySummonerName(summonerName);
		return riotAdapterService.getRunePagesDetailInfo(summonerId);
	}
}
