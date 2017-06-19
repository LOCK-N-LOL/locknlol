package com.locknlol.coukie.domain.riot.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@Repository
public interface SummonerAuthRepository extends JpaRepository<SummonerAuth, Long> {
	SummonerAuth findBySummonerName(String summonerName);
}
