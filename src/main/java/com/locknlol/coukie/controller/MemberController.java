package com.locknlol.coukie.controller;

import com.locknlol.coukie.domain.member.Member;
import com.locknlol.coukie.domain.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@Controller
@RequestMapping(value = "/api")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/v1/member", method = RequestMethod.POST)
	@ResponseBody
	public Member memberSave(@RequestBody Member member) {
		return memberService.saveMember(member);
	}
}
