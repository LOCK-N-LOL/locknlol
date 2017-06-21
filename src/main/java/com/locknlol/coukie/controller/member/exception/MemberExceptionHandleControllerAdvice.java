package com.locknlol.coukie.controller.member.exception;

import com.locknlol.coukie.domain.member.common.ErrorResponse;
import com.locknlol.coukie.domain.member.exception.MemberEmailDuplicatedException;
import com.locknlol.coukie.domain.member.exception.MemberInvalidPasswordException;
import com.locknlol.coukie.domain.member.exception.MemberNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by leetaejun on 2017. 6. 22..
 */
@Slf4j
@ControllerAdvice
public class MemberExceptionHandleControllerAdvice {
	@ExceptionHandler(MemberEmailDuplicatedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleMemberEmailDuplicatedException(MemberEmailDuplicatedException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(e.getEmail() + "은 이미 가입되어있는 Email 주소입니다.");
		errorResponse.setCode("member.save.duplicate");
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MemberInvalidPasswordException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleMemberInvalidPasswordException(MemberInvalidPasswordException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("암호를 다시 확인해주세요.");
		errorResponse.setCode("member.invalid.password");
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MemberNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleMemberNotFoundException(MemberNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(e.getNotFoundMessage() + "로는 사용자를 찾을 수 없습니다.");
		errorResponse.setCode("member.not.found");
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
