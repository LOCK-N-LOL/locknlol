package com.locknlol.coukie.domain.member.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by leetaejun on 2017. 6. 21..
 */
public class MemberDto {
	@Data
	public static class Request {
		@NotBlank
		@Size(min = 1)
		// @Pattern() 여기에 이메일 정규식을 추가하자
		private String email;

		@NotBlank
		@Size(min = 6)
		private String password;
	}

	@Data
	public static class Response {
		private Long id;
		private String email;
		private Date createdAt;
		private Date modifiedAt;
	}
}
