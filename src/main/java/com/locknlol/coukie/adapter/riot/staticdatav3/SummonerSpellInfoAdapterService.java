package com.locknlol.coukie.adapter.riot.staticdatav3;

import com.locknlol.coukie.adapter.riot.RiotAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 5.
 */
@Service
public class SummonerSpellInfoAdapterService {

    private final RiotAdapter riotAdapter;

    @Autowired
    public SummonerSpellInfoAdapterService(RiotAdapter riotAdapter) {
        this.riotAdapter = riotAdapter;
    }

    /*public SummonerSpellDto getSummonerSpellById(int id) {
        try {
            return riotAdapter.get(RiotRequests.SUMMONER_SPELL_BY_ID, Collections.singletonMap("id", id));
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Cannot find a summoner-spell: summoner-spell="+id, e);
        }
    }*/
/*
    public SummonerSpellListDto getAllSummonerSpells() {
        try {
            return riotAdapter.get(RiotRequests.SUMMONER_SPELLS);
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Cannot find summoner-spells", e);
        }
    }*/
}
