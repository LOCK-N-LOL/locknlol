package com.locknlol.coukie.domain.champion.repository;

import com.locknlol.coukie.domain.champion.entity.ChampionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kev on 2017. 6. 5.
 */
public interface ChampionInfoRepository extends JpaRepository<ChampionInfo, Long> {
}
