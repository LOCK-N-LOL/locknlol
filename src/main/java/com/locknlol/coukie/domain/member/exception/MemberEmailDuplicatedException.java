package com.locknlol.coukie.domain.member.exception;

/**
 * Created by leetaejun on 2017. 6. 22..
 */
public class MemberEmailDuplicatedException extends RuntimeException {
	private String email;

	public MemberEmailDuplicatedException(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
