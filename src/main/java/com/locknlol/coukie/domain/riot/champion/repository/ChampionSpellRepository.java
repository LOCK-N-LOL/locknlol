package com.locknlol.coukie.domain.riot.champion.repository;

import com.locknlol.coukie.domain.riot.champion.entity.ChampionSpell;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kev on 2017. 6. 5.
 */
public interface ChampionSpellRepository extends JpaRepository<ChampionSpell, Long>{
}