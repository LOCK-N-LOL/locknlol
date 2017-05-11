package com.locknlol.coukie.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Oscar on 2017. 5. 11..
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findBySummonerId(String summonerId);
}
