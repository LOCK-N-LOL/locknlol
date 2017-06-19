package com.locknlol.coukie.domain.riot.league;

import com.locknlol.coukie.adapter.riot.response.RiotLeaguesBySummonerIdResponse;
import com.locknlol.coukie.domain.riot.RiotAdapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Haylie
 * @since 2017. 6. 19..
 */

@Slf4j
@Service
public class RiotLeagueService {
    @Autowired
    RiotAdapterService riotAdapterService;

    public RiotLeaguesBySummonerIdResponse getLeaguesBySummonerId(Long summonerId) {
        return riotAdapterService.getAllLeaguesBySummonerId(summonerId);
    }

}
