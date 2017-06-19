package com.locknlol.coukie.domain.riot.auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Oscar on 2017. 6. 18..
 */
@RunWith(MockitoJUnitRunner.class)
public class SummonerAuthFindServiceTest {

	@InjectMocks
	private SummonerAuthFindService summonerAuthFindService;
	@Mock
	private SummonerAuthRepository repository;

	private SummonerAuth auth;

	@Before
	public void setUp() {
		auth = new SummonerAuth();
	}
	@Test
	public void return_false_when_summoner_not_exist_in_table() {
		when(repository.findBySummonerName(anyString())).thenReturn(null);
		Boolean result = summonerAuthFindService.checkAuthNotComplete("Oscar");
		assertFalse(result);
	}

	@Test
	public void return_false_when_summoner_auth_not_complete() {
		auth.setComplete(Boolean.FALSE);
		when(repository.findBySummonerName(anyString())).thenReturn(auth);
		Boolean result = summonerAuthFindService.checkAuthNotComplete("Oscar");
		assertFalse(result);
	}

	@Test
	public void return_true_when_summoner_auth_complete() {
		auth.setComplete(Boolean.TRUE);
		when(repository.findBySummonerName(anyString())).thenReturn(auth);
		Boolean result = summonerAuthFindService.checkAuthNotComplete("Oscar");
		assertTrue(result);
	}
}