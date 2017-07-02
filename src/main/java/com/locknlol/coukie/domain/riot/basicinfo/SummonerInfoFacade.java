package com.locknlol.coukie.domain.riot.basicinfo;

import com.locknlol.coukie.domain.riot.match.info.MatchBasicInfoDto;
import com.locknlol.coukie.domain.riot.match.info.MatchBasicStatDto;
import com.locknlol.coukie.domain.riot.match.info.MatchInfoService;
import com.locknlol.coukie.domain.riot.match.info.MatchStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oscar on 2017. 6. 24..
 */
@Service
public class SummonerInfoFacade {

	@Autowired
	private MatchInfoService matchInfoService;

	@Autowired
	private MatchStatService matchStatService;

	public List<MatchBasicInfoDto> recentMatchBasicInfos(String summonerName) {
		return matchInfoService.getRecentTenRankMatchsInfo(summonerName); //큐타입을 모르겠어서 enum이랑 연결 못함
	}

	public MatchBasicStatDto recentMatchBasicStats(String summonerName, int rankType, int queueType) {
		return matchStatService.getRecentTwentyMatchesStat(summonerName, rankType, queueType);
	}
}
