package com.locknlol.coukie.domain.riot.match.info;

import com.locknlol.coukie.domain.riot.match.RiotMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Haylie
 * @since 2017. 6. 26..
 */

@Service
public class MatchStatService {
    @Autowired
    RiotMatchService matchService;

    public MatchBasicStatDto getRecentTwentyMatchesStat(String summonerName, int rankType, int queueType) {
        return null;
    }

    private int getWinningAvg(int wins, int losses) {
        return wins * 5;
    }

    private int getKillingParticipationAvg(int kills, int assists, int deaths) {
        return 0;
    }
}
