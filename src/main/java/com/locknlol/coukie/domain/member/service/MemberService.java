package com.locknlol.coukie.domain.member.service;

import com.locknlol.coukie.domain.member.Member;
import com.locknlol.coukie.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leetaejun on 2017. 5. 31..
 */

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public Member saveUser(Member member) {
		if (member.getEmail() != null && member.getPassword() != null) {
			return memberRepository.save(member);
		}

		return null;
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member findById(Long id) {
		return memberRepository.findOne(id);
	}

	public void deleteUser(Member member) {
		memberRepository.delete(member.getId());
	}

	public boolean signInUser(Member member) {
		Member member1 = memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
		if(member1 != null){
			return true;
		}
		else{
			return false;
		}
	}
}
