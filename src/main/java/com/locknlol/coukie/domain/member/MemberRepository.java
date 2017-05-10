package com.locknlol.coukie.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Oscar on 2017. 5. 11..
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findBySummonerId(String summonerId);
}
