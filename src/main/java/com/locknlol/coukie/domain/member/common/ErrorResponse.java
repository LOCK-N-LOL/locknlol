package com.locknlol.coukie.domain.member.common;

import lombok.Data;

import java.util.List;

/**
 * Created by leetaejun on 2017. 6. 22..
 */
@Data
public class ErrorResponse {
	private String message;
	private String code;
	private List<FieldError> errors;

	// TODO : BindingResult 를 통해 얻을 수 있는 정보들을 추가적으로 담아볼까?
	public static class FieldError {
		private String field;
		private String value;
		private String reason;
	}
}
