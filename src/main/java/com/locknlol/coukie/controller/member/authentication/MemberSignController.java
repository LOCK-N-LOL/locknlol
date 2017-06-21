package com.locknlol.coukie.controller.member.authentication;

import com.locknlol.coukie.domain.member.dto.MemberDto;
import com.locknlol.coukie.domain.member.service.MemberSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leetaejun on 2017. 6. 20..
 */

@Controller
@RequestMapping(value = "/member")
public class MemberSignController {

	// TODO : 뷰 컨트롤러는 Exception 발생 시, 에러페이지를 만들어서 렌더링 해주자.

	@Autowired
	private MemberSignService memberSignService;

	@RequestMapping(value = "/signin/form")
	public String signInForm() {
		return "/member/sign/signin";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signInAction(@ModelAttribute @Valid MemberDto.Request requestDto, HttpSession session, BindingResult result) {
		if (result.hasErrors()) {
			// TODO : 에러 뷰 페이지로 이동
		}

		// TODO : session 정상동작하는 지 확인해 볼 것.
		if (memberSignService.signIn(requestDto)) {
			Map<String,Object> map = new HashMap<>();
			map.put("admin_id", "admin");
			map.put("admin_name" , "유저");
			session.setAttribute("admin",map);
			return "redirect:/hello";
		}
		return signInForm();
	}

	@RequestMapping(value = "/signup/form")
	public String signUpForm() {
		return "/member/sign/signup";
	}

	@RequestMapping(value = "/signup/new", method = RequestMethod.POST)
	public String signUpNew(@ModelAttribute @Valid MemberDto.Request requestDto, BindingResult result) {
		if (result.hasErrors()) {
			// TODO : 에러 뷰 페이지로 이동
		}

		if (memberSignService.signUp(requestDto) == null) {
			return "/member/signup/form";
		}

		// TODO : 가입 성공 시 처리를 여기서.
		return "redirect:/member/signin/form";
	}
}
