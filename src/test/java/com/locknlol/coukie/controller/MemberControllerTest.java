package com.locknlol.coukie.controller;

import com.locknlol.coukie.domain.member.Member;
import com.locknlol.coukie.domain.member.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

	@InjectMocks
	private MemberController memberController;
	@Mock
	private MemberService memberService;


	@Test
	public void member_save_test() {
		memberController.memberSave(new Member());

		verify(memberService).saveMember(any(Member.class));
	}
}