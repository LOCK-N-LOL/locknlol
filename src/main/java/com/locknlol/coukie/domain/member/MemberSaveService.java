package com.locknlol.coukie.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 5. 11..
 */
@Service
public class MemberSaveService {
	@Autowired
	private MemberRepository repository;

	public Member saveMember(Member member) {
		return repository.save(member);
	}
}
