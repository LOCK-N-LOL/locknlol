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
 *
 * Best practice for Designing for a restful api.
 * @see <a href="http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api">http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api</a>)
 */

@RestController
@RequestMapping(value = "/admin/members")
public class MemberAdminController {
	@Autowired
	private MemberRepositoryService memberRepositoryService;

	/**
	 * Summary : Create member
	 * Notes :
	 * API : POST /admin/members
	 * @param MemberDto.Creation creationDto (required)
	 * @param BindingResult result <Result binding>
	 * @return ResponseEntity type
	 * @throws MemberEmailDuplicatedException if fails to make API call
	 * @throws MemberInvalidPasswordException if fails to make API call
	 * @see
	 */
	@PostMapping(value = "/")
	public ResponseEntity createMember(@RequestBody @Valid MemberDto.Creation creationDto, BindingResult result) {
		if (result.hasErrors()) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("잘못된 요청입니다.");
			errorResponse.setCode("bad.request");

			// TODO BindingResult 안에 들어있는 에러 정보 사용하기.
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		MemberDto.Response newMember = memberRepositoryService.save(creationDto);
		return new ResponseEntity<>(newMember, HttpStatus.CREATED);
	}

	/**
	 * Summary : Find all members
	 * Notes :
	 * API : GET /admin/members
	 * @return ResponseEntity type
	 * @see
	 */
	@GetMapping(value = "/")
	public ResponseEntity findAllMember() {
		return new ResponseEntity<>(memberRepositoryService.findAll(), HttpStatus.OK);
	}

	/**
	 * Summary : Find one members
	 * Notes :
	 * API : GET /admin/members/{id}
	 * @return ResponseEntity type
	 * @throws MemberNotFoundException
	 * @see
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity findOneMember(@PathVariable Long id) {
		return new ResponseEntity<>(memberRepositoryService.findOne(id), HttpStatus.OK);
	}

	/**
	 * Summary : Modify one member information.
	 * Notes :
	 * API : PUT /admin/members/{id}
	 * @return ResponseEntity type
	 * @throws MemberNotFoundException
	 * @see
	 */
	// 전체 업데이트 ( PUT )
	@PutMapping(value = "/{id}")
	public ResponseEntity modifyMember(@PathVariable Long id, @RequestBody @Valid MemberDto.Modification modificationDto, BindingResult result) {
		MemberDto.Response updateMember = memberRepositoryService.modify(modificationDto);
		return new ResponseEntity<>(updateMember, HttpStatus.OK);
	}

	// 부분 업데이트 ( PATCH )
}
