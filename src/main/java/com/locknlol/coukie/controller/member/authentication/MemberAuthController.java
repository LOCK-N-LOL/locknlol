package com.locknlol.coukie.controller.member.authentication;

import com.locknlol.coukie.domain.member.Member;
import com.locknlol.coukie.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by leetaejun on 2017. 5. 31..
 */

@Controller
@RequestMapping(value = "/member")
public class MemberAuthController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/signup/form")
	public String signupForm() {
		return "/member/authentication/signup";
	}

	@RequestMapping(value = "/signup/new", method = RequestMethod.POST)
	public String signupNew(Member member) {
		if (memberService.save(member) == null) {
			return "/member/signup/form";
		}
		return "/member/signin/form";
	}

	@RequestMapping(value = "/signin/form")
	public String signInForm() {
		return "/member/authentication/signin";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signInAction(Member member) {
		if (memberService.signInUser(member)) {
			return "redirect:/hello";
		}
		return signInForm();
	}
}
