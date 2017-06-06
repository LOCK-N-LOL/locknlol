package com.locknlol.coukie.domain.champion.repository;

import com.locknlol.coukie.domain.champion.entity.ChampionTags;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kev on 2017. 6. 5.
 */
public interface ChampionTagsRepository extends JpaRepository<ChampionTags, Long>{
}
