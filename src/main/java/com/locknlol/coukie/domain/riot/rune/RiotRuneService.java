package com.locknlol.coukie.domain.riot.rune;

import com.locknlol.coukie.adapter.riot.dto.rune.RiotRunePagesResponse;
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
public class RiotRuneService {
    @Autowired
    RiotAdapterService riotAdapterService;

    @Autowired
    RiotSummonerService riotSummonerService;

    public RiotRunePagesResponse getRunePagesDetailInfo(String summonerName) {
        Long summonerId = riotSummonerService.getSummonerIdBySummonerName(summonerName);
        return riotAdapterService.getRunePagesDetailInfo(summonerId);
    }

}
