package com.locknlol.coukie.domain.member.exception;

/**
 * Created by leetaejun on 2017. 6. 22..
 */
public class MemberNotFoundException extends RuntimeException {

	private String notFoundMessage;

	public MemberNotFoundException(Long memberId) {
		this.notFoundMessage = memberId.toString();
	}

	public MemberNotFoundException(String email) {
		this.notFoundMessage = email;
	}

	public String getNotFoundMessage() {
		return notFoundMessage;
	}
}
