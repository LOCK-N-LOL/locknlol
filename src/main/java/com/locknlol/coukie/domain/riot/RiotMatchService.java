package com.locknlol.coukie.domain.riot;

import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Haylie
 * @since 2017. 6. 19..
 */

@Slf4j
@Service
public class RiotMatchService {
    @Autowired
    RiotAdapterService riotAdapterService;

    @Autowired
    RiotSummonerService riotSummonerService;

    public RiotMatchResponse getRecentMatches(String summonerName) {
        Long accountId = riotSummonerService.getAccountIdBySummonerName(summonerName);
        return riotAdapterService.getRecentMatchesByAccountId(accountId);
    }

    public RiotMatchByMatchIdResponse getMatchByMatchId(Long matchId) {
        return riotAdapterService.getMatchByMatchId(matchId);
    }

    public RiotMatchResponse getAllMatches(String summonerName) {
        Long accountId = riotSummonerService.getAccountIdBySummonerName(summonerName);
        return riotAdapterService.getAllMatches(accountId);
    }
}
