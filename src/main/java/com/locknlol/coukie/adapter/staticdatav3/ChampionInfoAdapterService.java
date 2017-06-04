package com.locknlol.coukie.adapter.staticdatav3;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by kev on 2017. 5. 25.
 */
@Service
public class ChampionInfoAdapterService {

	private final RiotAdapter riotAdapter;

	@Autowired
	public ChampionInfoAdapterService(RiotAdapter riotAdapter) {
		this.riotAdapter = riotAdapter;
	}

	public ChampionDto getChampionById(int id) {
		try {
			return riotAdapter.get(RiotRequests.CHAMPOION_BY_ID, RiotApiUrl.STATIC_DATA_V3_CHAMPION_BY_ID, Collections.singletonMap("id", id));
		} catch (Exception e) {
			throw new DataRetrievalFailureException("Cannot find a champion: championId="+id, e);
		}
	}

	public ChampionListDto getAllChampion() {
		try {
			return riotAdapter.get(RiotRequests.CHAMPOIONS, RiotApiUrl.STATIC_DATA_V3_CHAMPION_ALL);
		} catch (Exception e) {
			throw new DataRetrievalFailureException("Cannot find champions", e);
		}
	}


}
