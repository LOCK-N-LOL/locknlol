package com.locknlol.coukie.controller.member.admin;

import com.locknlol.coukie.domain.member.common.ErrorResponse;
import com.locknlol.coukie.domain.member.dto.MemberDto;
import com.locknlol.coukie.domain.member.exception.MemberEmailDuplicatedException;
import com.locknlol.coukie.domain.member.exception.MemberInvalidPasswordException;
import com.locknlol.coukie.domain.member.exception.MemberNotFoundException;
import com.locknlol.coukie.domain.member.service.MemberRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by leetaejun on 2017. 5. 31..
 */

@RestController
@RequestMapping(value = "/admin/member")
public class MemberAdminController {
	@Autowired
	private MemberRepositoryService memberRepositoryService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity createMember(@RequestBody @Valid MemberDto.Request requestDto, BindingResult result) {
		if (result.hasErrors()) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("잘못된 요청입니다.");
			errorResponse.setCode("bad.request");

			// TODO BindingResult 안에 들어있는 에러 정보 사용하기.
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		MemberDto.Response newMember = memberRepositoryService.save(requestDto);
		return new ResponseEntity<>(newMember, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/list")
	public ResponseEntity findAllMember() {
		return new ResponseEntity<>(memberRepositoryService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/list/{memberId}")
	public ResponseEntity findOneMember(@PathVariable Long memberId) {
		return new ResponseEntity<>(memberRepositoryService.findOne(memberId), HttpStatus.OK);
	}
}
