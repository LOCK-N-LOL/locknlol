package com.locknlol.coukie.controller.member.admin;

import com.locknlol.coukie.domain.member.Member;
import com.locknlol.coukie.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by leetaejun on 2017. 5. 31..
 */

@Controller
@RequestMapping(value = "/admin/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	// create
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Member saveUser(@RequestBody Member member) {
		return memberService.save(member);
	}

	// read
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Member> findAll() {
		return memberService.findAll();
	}

	// read
	@RequestMapping(value = "/{id}")
	@ResponseBody
	public Member find(@PathVariable Long id) {
		return memberService.findById(id);
	}

	// update
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Member update(@RequestBody Member member) {
		return memberService.save(member);
	}

	// delete
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestBody Member member) {
		memberService.deleteById(member);
	}
}
