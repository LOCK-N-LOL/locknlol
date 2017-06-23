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

	public boolean signIn(MemberDto.Creation creationDto) {
		return memberRepositoryService.isValidMember(creationDto);
	}

	public MemberDto.Response signUp(MemberDto.Creation creationDto) {
		return memberRepositoryService.save(creationDto);
	}

	private MemberDto.Response modifyMember(MemberDto.Modification modificationDto) {
		return memberRepositoryService.modify(modificationDto);
	}
}
