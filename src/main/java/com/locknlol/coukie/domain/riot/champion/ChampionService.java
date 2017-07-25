package com.locknlol.coukie.domain.riot.champion;

import com.google.common.base.Preconditions;
import com.locknlol.coukie.domain.riot.champion.entity.Champion;
import com.locknlol.coukie.domain.riot.champion.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kev on 2017. 7. 18.
 */
@Service
public class ChampionService {

	@Autowired
	private ChampionRepository championRepository;

	public Champion getChampion(Long championId) {
		Champion one = championRepository.findOne(championId);
		Preconditions.checkNotNull(one, "존재하는 챔피언이 없습니다");
		return one;
	}
}
