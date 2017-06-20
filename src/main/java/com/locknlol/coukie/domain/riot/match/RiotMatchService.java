package com.locknlol.coukie.domain.riot.match;

import com.locknlol.coukie.adapter.riot.dto.RiotMatchByMatchIdDto;
import com.locknlol.coukie.adapter.riot.dto.RiotMatchDto;
import com.locknlol.coukie.adapter.riot.RiotAdapterService;
import com.locknlol.coukie.domain.riot.summoner.RiotSummonerService;
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

    public RiotMatchDto getRecentMatches(String summonerName) {
        Long accountId = riotSummonerService.getAccountIdBySummonerName(summonerName);
        return riotAdapterService.getRecentMatchesByAccountId(accountId);
    }

    public RiotMatchByMatchIdDto getMatchByMatchId(Long matchId) {
        return riotAdapterService.getMatchByMatchId(matchId);
    }

    public RiotMatchDto getAllMatches(String summonerName) {
        Long accountId = riotSummonerService.getAccountIdBySummonerName(summonerName);
        return riotAdapterService.getAllMatches(accountId);
    }
}
