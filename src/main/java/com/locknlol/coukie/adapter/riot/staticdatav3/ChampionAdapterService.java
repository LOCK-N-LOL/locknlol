package com.locknlol.coukie.adapter.riot.staticdatav3;

import com.locknlol.coukie.adapter.riot.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

/**
 * Created by kev on 2017. 5. 25.
 */
@Service
public class ChampionAdapterService {

	private final RiotAdapter riotAdapter;

	@Autowired
	public ChampionAdapterService(RiotAdapter riotAdapter) {
		this.riotAdapter = riotAdapter;
	}

/*	public ChampionDto getChampionById(int id) {
		try {
			return riotAdapter.get(RiotRequests.CHAMPOION_BY_ID, Collections.singletonMap("id", id));
		} catch (Exception e) {
			throw new DataRetrievalFailureException("Cannot find a champion: championId="+id, e);
		}
	}*/

	public ChampionListDto getAllChampion() {
		try {
			return riotAdapter.get(RiotRequests.CHAMPOIONS);
		} catch (Exception e) {
			throw new DataRetrievalFailureException("Cannot find champions", e);
		}
	}


}
