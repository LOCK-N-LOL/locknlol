package com.locknlol.coukie.domain.riot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@Service
public class SummonerAuthFindService {

	@Autowired
	private SummonerAuthRepository repository;

	public SummonerAuth findBySummonerName(String summonerName) {
		return repository.findBySummonerName(summonerName);
	}

	public boolean checkAuthNotComplete(String summonerName) {
		SummonerAuth summonerAuth =
			repository.findBySummonerName(summonerName);
		return Optional.ofNullable(summonerAuth)
			.map(SummonerAuth::getComplete)
			.orElse(Boolean.FALSE);
	}
}
