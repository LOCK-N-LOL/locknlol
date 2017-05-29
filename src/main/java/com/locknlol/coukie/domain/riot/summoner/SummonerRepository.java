package com.locknlol.coukie.domain.riot.summoner;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oscar on 2017. 5. 28..
 */
public interface SummonerRepository extends JpaRepository<Summoner, Long> {

	Summoner findBySummonerName(String summonerName);
}
