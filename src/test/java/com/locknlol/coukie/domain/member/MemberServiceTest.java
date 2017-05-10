package com.locknlol.coukie.domain.member;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Oscar on 2017. 5. 11..
 */
@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
	@InjectMocks
	private MemberService memberService;
	@Mock
	private MemberFindService memberFindService;
	@Mock
	private MemberSaveService memberSaveService;

	private Member member;

	@Before
	public void setUp() {
		member = new Member();
		member.setId(1L);
		member.setPassword("abcd");
		member.setSummonerId("oscar");
	}

	@Test
	public void save_member_if_summonId_does_not_exist_Test() {
		when(memberFindService.findBySummonerId(anyString())).thenReturn(null);

		memberService.saveMember(member);

		verify(memberSaveService).saveMember(member);

	}
}