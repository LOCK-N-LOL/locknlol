package com.locknlol.coukie.domain.riot.exception;

import com.locknlol.coukie.exception.ErrorCode;
import lombok.Getter;

/**
 * Created by Oscar on 2017. 5. 28..
 */
@Getter
public class RiotException extends RuntimeException {

	private final ErrorCode errorCode;

	public RiotException(ErrorCode errorCode) {
		super(errorCode.getCause());
		this.errorCode = errorCode;
	}

	public RiotException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getCause(), cause);
		this.errorCode = errorCode;
	}
}
