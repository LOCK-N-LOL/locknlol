package com.locknlol.coukie.domain.riot;

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
 * @author Haylie
 * @since 2017. 6. 19..
 */

@Slf4j
@Service
public class RiotSummonerService {
    @Autowired
    RiotAdapterService riotAdapterService;

    @Autowired
    private SummonerFindService summonerFindService;
    @Autowired
    private SummonerSaveService summonerSaveService;

    public RiotSummonerByNameResponse getSummonerByName(String summonerName) {
        return riotAdapterService.getSummonerByName(summonerName);
    }

    private void saveSummoner(RiotSummonerByNameResponse response) {
        Optional.of(response)
                .ifPresent(res -> summonerSaveService.save(res));
    }

    public Long getAccountIdBySummonerName(String summonerName) {
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

    private Long getSummonerIdBySummonerName(String summonerName) {
        Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
        if (summonerInfo != null) {
            return summonerInfo.getId();
        }

        RiotSummonerByNameResponse response = getSummonerByName(summonerName);
        saveSummoner(response);

        return Optional.ofNullable(response)
                .map(RiotSummonerByNameResponse::getSummonerId)
                .orElseThrow(() -> new RiotException(RiotErrorCode.SUMMONER_NOT_FOUND));
    }

}
