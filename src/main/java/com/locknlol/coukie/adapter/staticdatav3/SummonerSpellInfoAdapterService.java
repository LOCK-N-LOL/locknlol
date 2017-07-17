package com.locknlol.coukie.adapter.staticdatav3;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellDto;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.util.Collections;

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

    public SummonerSpellDto getSummonerSpellById(int id) {
        try {
            return riotAdapter.get(RiotRequests.SUMMONER_SPELL_BY_ID, Collections.singletonMap("id", id));
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Cannot find a summoner-spell: summoner-spell="+id, e);
        }
    }
/*
    public SummonerSpellListDto getAllSummonerSpells() {
        try {
            return riotAdapter.get(RiotRequests.SUMMONER_SPELLS);
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Cannot find summoner-spells", e);
        }
    }*/
}
