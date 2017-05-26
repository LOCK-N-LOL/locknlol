package com.locknlol.coukie.domain.champion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kev on 2017. 5. 26.
 */
@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {
}
