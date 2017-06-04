package com.locknlol.coukie.domain.riot;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotAdapterParameter;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;
import com.locknlol.coukie.domain.riot.summoner.Summoner;
import com.locknlol.coukie.domain.riot.summoner.SummonerFindService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by Oscar on 2017. 5. 28..
 */
@RunWith(MockitoJUnitRunner.class)
public class RiotRealTimeCallServiceTest {
	@InjectMocks
	private RiotRealTimeCallService riotRealTimeCallService;
	@Mock
	private SummonerFindService summonerFindService;
	@Mock
	private RiotAdapter adapter;

	private Summoner summoner;
	private RiotSummonerByNameResponse response;

	private static final String SUMMONER_NAME = "love";

	@Before
	public void setUp() {
		summoner = new Summoner();
		summoner.setAccountId(1L);

		response = new RiotSummonerByNameResponse();
		response.setAccountId(1L);
	}

	@Test
	public void not_try_api_call_when_db_has_summoner_info() throws Exception {
		when(summonerFindService.findBySummonerName(SUMMONER_NAME)).thenReturn(summoner);

		riotRealTimeCallService.getRecentMatches(SUMMONER_NAME);

		verify(adapter, never()).get(RiotRequests.SUMMONER_BY_NAME,
			RiotAdapterParameter.summonerByName(SUMMONER_NAME));
	}

	@Test
	public void try_api_call_when_summnoer_info_not_in_db() throws Exception {
		when(summonerFindService.findBySummonerName(SUMMONER_NAME)).thenReturn(null);
		when(adapter.get(RiotRequests.SUMMONER_BY_NAME, RiotAdapterParameter.summonerByName(SUMMONER_NAME))).thenReturn(response);

		riotRealTimeCallService.getRecentMatches(SUMMONER_NAME);

		verify(adapter).get(RiotRequests.SUMMONER_BY_NAME, RiotAdapterParameter.summonerByName(SUMMONER_NAME));
		verify(adapter).get(RiotRequests.RECENT_MATCHES, RiotAdapterParameter.recentMatchByAccountId(
			response.getAccountId()));
	}
}