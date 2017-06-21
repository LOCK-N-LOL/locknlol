package com.locknlol.coukie.domain.member.service;

import com.locknlol.coukie.domain.member.dto.MemberDto;
import com.locknlol.coukie.domain.member.entity.Member;
import com.locknlol.coukie.domain.member.exception.MemberEmailDuplicatedException;
import com.locknlol.coukie.domain.member.exception.MemberInvalidPasswordException;
import com.locknlol.coukie.domain.member.exception.MemberNotFoundException;
import com.locknlol.coukie.domain.member.repository.MemberRepository;
import com.locknlol.coukie.domain.member.security.MemberSecurityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leetaejun on 2017. 6. 20..
 */

@Service
public class MemberRepositoryService {
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberSecurityService memberSecurityService;

	public List<MemberDto.Response> findAll() {
		List<Member> foundMembers = memberRepository.findAll();
		List<MemberDto.Response> responseDtos = new ArrayList<>();
		foundMembers.forEach(member -> {
			MemberDto.Response responseDto = new MemberDto.Response();
			BeanUtils.copyProperties(member, responseDto);
			responseDtos.add(responseDto);
		});
		return responseDtos;
	}

	public MemberDto.Response findOne(Long memberId)  {
		Member foundMember = memberRepository.findOne(memberId);
		if (foundMember == null) {
			throw new MemberNotFoundException(memberId);
		}
		MemberDto.Response responseDto = new MemberDto.Response();
		BeanUtils.copyProperties(foundMember, responseDto);
		return responseDto;
	}

	public boolean isValidMember(MemberDto.Request requestDto)  {
		return isValidPassword(requestDto);
	}

	public MemberDto.Response save(MemberDto.Request requestDto) {
		if (memberRepository.findByEmail(requestDto.getEmail()) != null) {
			throw new MemberEmailDuplicatedException(requestDto.getEmail());
		}
		if (requestDto.getPassword().length() < 6) {
			throw new MemberInvalidPasswordException();
		}

		Member member = new Member();
		member.setEmail(requestDto.getEmail());
		member.setPassword(cryptPassword(requestDto.getPassword()));
		Date now = new Date();
		member.setCreatedAt(now);
		member.setModifiedAt(now);
		memberRepository.save(member);

		MemberDto.Response responseDto = new MemberDto.Response();
		BeanUtils.copyProperties(member, responseDto);
		return responseDto;
	}

	public MemberDto.Response modify(MemberDto.Request requestDto)  {
		Member foundMember = memberRepository.findByEmail(requestDto.getEmail());
		if (foundMember == null) {
			throw new MemberNotFoundException(requestDto.getEmail());
		}

		foundMember.setPassword(cryptPassword(requestDto.getPassword()));
		foundMember.setModifiedAt(new Date());
		Member newMember = memberRepository.save(foundMember);

		MemberDto.Response responseDto = new MemberDto.Response();
		BeanUtils.copyProperties(newMember, responseDto);
		return responseDto;
	}

	private String cryptPassword(String password) {
		return memberSecurityService.cryptPassword(password);
	}

	private boolean isValidPassword(MemberDto.Request requestDto)  {
		Member foundMember = memberRepository.findByEmail(requestDto.getEmail());
		if (foundMember == null) {
			throw new MemberNotFoundException(requestDto.getEmail());
		}
		return memberSecurityService.confirmPassword(foundMember, requestDto.getPassword());
	}
}
