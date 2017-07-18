package com.locknlol.coukie.adapter.riot;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.dto.*;
import com.locknlol.coukie.adapter.riot.dto.rune.RiotRunePagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Oscar on 2017. 6. 4..
 */
@Service
public class RiotAdapterService {

	@Autowired
	private RiotAdapter riotAdapter;

	public RiotSummonerByNameDto getSummonerByName(String summonerName) {
		return riotAdapter.get(RiotRequests.SUMMONER_BY_NAME, RiotAdapterParameter.getSummonerNameParam(summonerName));
	}

	public RiotMatchDto getRecentMatchesByAccountId(Long accountId) {
		return riotAdapter.get(RiotRequests.RECENT_MATCHES, RiotAdapterParameter.getAccountIdParam(accountId));
	}

	public RiotMatchByMatchIdDto getMatchByMatchId(Long matchId) {
		return riotAdapter.get(RiotRequests.MATCH_BY_MATCH_ID, RiotAdapterParameter.getMatchIdParam(matchId));
	}

	public RiotMatchDto getAllMatches(Long accountId) {
		return riotAdapter.get(RiotRequests.All_MATCHES, RiotAdapterParameter.getAccountIdParam(accountId));
	}

	public RiotLeaguesBySummonerIdDto getAllLeaguesBySummonerId(Long summonerId) {
		return riotAdapter.get(RiotRequests.ALL_LEAGUES, RiotAdapterParameter.getSummonerId(summonerId));
	}

	public RiotRunePagesResponse getRunePagesDetailInfo(Long summonerId) {
		return riotAdapter.get(RiotRequests.RUNE_PAGES, RiotAdapterParameter.getSummonerId(summonerId));
	}

	public List<LeaguePositionDto> getLeaguePosition(Long summonerId) {
		LeaguePositionDto[] leaguePositionDtos = riotAdapter.get(RiotRequests.LEAGUE_POSITION, RiotAdapterParameter.getSummonerId(summonerId));
		return Arrays.asList(leaguePositionDtos);
	}
}
