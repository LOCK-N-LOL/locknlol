package com.locknlol.coukie.domain.member.service;

import com.locknlol.coukie.domain.member.Member;
import com.locknlol.coukie.domain.member.repository.MemberRepository;
import com.locknlol.coukie.domain.member.security.MemberSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by leetaejun on 2017. 5. 31..
 */

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberSecurityService memberSecurityService;

	public Member signUp(Member member) {
		member = setCryptPassword(member);
		return saveMember(member);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public void deleteById(Member member) {
		memberRepository.delete(member);
	}

	public boolean signIn(Member member) {
		return confirmUserPassword(member);
	}

	private boolean confirmUserPassword(Member member) {
		Member savedMember = memberRepository.findByEmail(member.getEmail());
		return memberSecurityService.confirmPassword(savedMember, member.getPassword());
	}

	private Member setCryptPassword(Member member) {
		String plainPassword = member.getPassword();
		String cryptPassword = memberSecurityService.cryptPassword(plainPassword);
		member.setPassword(cryptPassword);
		return member;
	}

	private Member saveMember(Member member) {
		member.setCreatedAt(new Date());
		member.setModifiedAt(new Date());
		return memberRepository.save(member);
	}
}
