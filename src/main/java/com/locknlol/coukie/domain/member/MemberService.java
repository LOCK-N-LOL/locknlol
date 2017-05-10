package com.locknlol.coukie.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@Service
public class MemberService {
	@Autowired
	private MemberFindService memberFindService;
	@Autowired
	private MemberSaveService memberSaveService;

	public Member saveMember(Member member) {
		if(memberFindService.findBySummonerId(member.getSummonerId()) == null) {
			memberSaveService.saveMember(member);
		}
		return null;
	}
}
