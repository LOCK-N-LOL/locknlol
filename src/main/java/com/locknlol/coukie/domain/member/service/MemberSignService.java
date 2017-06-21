package com.locknlol.coukie.domain.member.service;

import com.locknlol.coukie.domain.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leetaejun on 2017. 6. 20..
 */

@Service
public class MemberSignService {

	@Autowired
	private MemberRepositoryService memberRepositoryService;

	public boolean signIn(MemberDto.Request requestDto) {
		return memberRepositoryService.isValidMember(requestDto);
	}

	public MemberDto.Response signUp(MemberDto.Request requestDto) {
		return memberRepositoryService.save(requestDto);
	}

	private MemberDto.Response modifyMember(MemberDto.Request requestDto) {
		return memberRepositoryService.modify(requestDto);
	}
}
