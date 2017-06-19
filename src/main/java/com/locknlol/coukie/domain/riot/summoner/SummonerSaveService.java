package com.locknlol.coukie.domain.riot.summoner;

import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Oscar on 2017. 6. 4..
 */
@Service
public class SummonerSaveService {

	@Autowired
	private SummonerRepository repository;

	public void save(RiotSummonerByNameResponse response) {
		Summoner summoner = Optional.of(response)
			.map(Summoner::convert).get();
		repository.save(summoner);
	}
}
