package com.locknlol.coukie.domain.riot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@Service
public class SummonerAuthSaveService {

	@Autowired
	private SummonerAuthRepository repository;

	public SummonerAuth update(String summonerName) {
		SummonerAuth auth = repository.findBySummonerName(summonerName);
		if (auth == null) {
			SummonerAuth summonerAuth = new SummonerAuth();
			summonerAuth.setSummonerName(summonerName);
			summonerAuth.setAuthKey(AuthKeyGenerator.generateAuthKey());
			summonerAuth.setCreatedAt(new Date());
			summonerAuth.setCreatedBy("auth_service");
			return repository.save(summonerAuth);
		}

		auth.setAuthKey(AuthKeyGenerator.generateAuthKey());
		return repository.save(auth);
	}

	public void authComplete(String summonerName) {
		SummonerAuth summonerAuth = repository.findBySummonerName(summonerName);
		summonerAuth.setComplete(Boolean.TRUE);
		repository.save(summonerAuth);
	}
}
