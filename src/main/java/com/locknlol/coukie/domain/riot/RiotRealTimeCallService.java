package com.locknlol.coukie.domain.riot;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotAdapterParameter;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.response.LolRecentMatchesResponse;
import com.locknlol.coukie.adapter.riot.response.LolSummonerByNameResponse;
import com.locknlol.coukie.domain.riot.summoner.Summoner;
import com.locknlol.coukie.domain.riot.summoner.SummonerFindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

	public LolSummonerByNameResponse findSummonerByName(String summonerName) throws Exception {
		return adapter.get(RiotRequests.SUMMONER_BY_NAME, RiotApiUrl.SUMMONER, RiotAdapterParameter.summonerByName(summonerName));
	}

	public LolRecentMatchesResponse getRecentMatches(String summonerName) throws Exception {
		Long accountId = getAccountIdBySummonerName(summonerName);
		return adapter.get(RiotRequests.RECENT_MATCHES, RiotApiUrl.RECENT_MATCHES_BY_ACCOUNTID,
			RiotAdapterParameter.recentMatchByAccountId(accountId));
	}

	/**
	 * api는 accoundId로 콜해야되는데 우리는 소환사 명 밖에 모름 아래에서는 api를 찔러서 가져온 다음에 다시 찔러야함
	 * 일단 기본 정보는 쌓는 db 정도는 하는게 어떨지? 그냥 api 콜로 처리??
	 * @param summonerName 소환사 명
	 * @return accountId
	 * @throws Exception
	 */
	private Long getAccountIdBySummonerName(String summonerName) throws Exception {
		Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
		if (summonerInfo != null) {
			return summonerInfo.getAccountId();
		}

		LolSummonerByNameResponse response = findSummonerByName(summonerName);
		Assert.notNull(response, summonerName + "에 해당하는 소환사 정보가 존재하지 않습니다.");

		return response.getAccountId();
	}
}
