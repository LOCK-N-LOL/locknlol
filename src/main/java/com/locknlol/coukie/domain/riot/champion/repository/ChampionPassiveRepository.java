package com.locknlol.coukie.domain.riot.champion.repository;

import com.locknlol.coukie.domain.riot.champion.entity.ChampionPassive;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kev on 2017. 6. 5.
 */
public interface ChampionPassiveRepository extends JpaRepository<ChampionPassive, Long> {
}