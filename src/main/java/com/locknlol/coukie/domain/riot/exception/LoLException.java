package com.locknlol.coukie.domain.riot.exception;

import com.locknlol.coukie.exception.ErrorCode;
import lombok.Getter;

/**
 * Created by Oscar on 2017. 5. 28..
 */
@Getter
public class LoLException extends RuntimeException {

	private final ErrorCode errorCode;

	public LoLException(ErrorCode errorCode) {
		super(errorCode.getCause());
		this.errorCode = errorCode;
	}

	public LoLException(ErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}
}
