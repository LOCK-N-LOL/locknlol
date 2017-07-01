package com.locknlol.coukie.domain.riot.summoner;

import com.locknlol.coukie.adapter.riot.dto.RiotSummonerByNameDto;
import com.locknlol.coukie.adapter.riot.RiotAdapterService;
import com.locknlol.coukie.domain.riot.exception.RiotErrorCode;
import com.locknlol.coukie.domain.riot.exception.RiotException;
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

    public RiotSummonerByNameDto getSummonerByName(String summonerName) {
        return riotAdapterService.getSummonerByName(summonerName);
    }

    private void saveSummoner(RiotSummonerByNameDto response) {
        Optional.of(response)
                .ifPresent(res -> summonerSaveService.save(res));
    }

    public Long getAccountIdBySummonerName(String summonerName) {
//        Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
//        if (summonerInfo != null) {
//            return summonerInfo.getAccountId();
//        }

        RiotSummonerByNameDto response = getSummonerByName(summonerName);
        saveSummoner(response);

        return Optional.ofNullable(getSummonerByName(summonerName))
                .map(RiotSummonerByNameDto::getAccountId)
                .orElseThrow(() -> new RiotException(RiotErrorCode.SUMMONER_NOT_FOUND));
    }

    public Long getSummonerIdBySummonerName(String summonerName) {
        Summoner summonerInfo = summonerFindService.findBySummonerName(summonerName);
        if (summonerInfo != null) {
            return summonerInfo.getId();
        }

        RiotSummonerByNameDto response = getSummonerByName(summonerName);
        saveSummoner(response);

        return Optional.ofNullable(response)
                .map(RiotSummonerByNameDto::getSummonerId)
                .orElseThrow(() -> new RiotException(RiotErrorCode.SUMMONER_NOT_FOUND));
    }



}
