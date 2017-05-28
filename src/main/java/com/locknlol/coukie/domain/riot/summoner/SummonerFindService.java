package com.locknlol.coukie.domain.riot.summoner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 5. 28..
 */
@Service
public class SummonerFindService {

	@Autowired
	private SummonerRepository summonerRepository;

	public Summoner findBySummonerName(String summonerName) {
		return summonerRepository.findBySummonerName(summonerName);
	}
}
