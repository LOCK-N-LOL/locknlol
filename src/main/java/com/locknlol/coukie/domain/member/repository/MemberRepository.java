package com.locknlol.coukie.domain.member.repository;

import com.locknlol.coukie.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByEmailAndPassword(String email, String password);
}
