package com.locknlol.coukie.adapter.staticdatav3;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import com.locknlol.coukie.domain.champion.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by kev on 2017. 5. 25.
 */
@Component
public class StaticDataV3Adapter {

	private final RiotAdapter riotAdapter;

	@Autowired
	public StaticDataV3Adapter(RiotAdapter riotAdapter) {
		this.riotAdapter = riotAdapter;
	}

	public ChampionDto getJaxTest() throws Exception{
		return riotAdapter.get(RiotRequests.CHAMPOION_BY_ID, RiotApiUrl.STATIC_DATA_V3_CHAMPION_BY_ID, Collections.singletonMap("id", 24L));
	}


}
