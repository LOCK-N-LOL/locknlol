package com.locknlol.coukie.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@Service
public class MemberFindService {

	@Autowired
	private MemberRepository repository;

	public Member findBySummonerId(String summonerId) {
		return repository.findBySummonerId(summonerId);
	}
}
