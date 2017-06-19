package com.locknlol.coukie.domain.riot.auth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@RunWith(MockitoJUnitRunner.class)
public class SummonerAuthServiceTest {

	@InjectMocks
	private SummonerAuthService summonerAuthService;
	@Mock
	private SummonerAuthFindService authFindService;

	private SummonerAuth summonerAuth;

	@Before
	public void setUp() {
		summonerAuth = new SummonerAuth();
		summonerAuth.setAuthKey("a123456");
	}
	@Test
	public void check_rune_page_has_same_value_test() {
		when(authFindService.findBySummonerName("balarmram")).thenReturn(summonerAuth);

	}
}