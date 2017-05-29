package com.locknlol.coukie.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Oscar on 2017. 5. 28..
 */
public interface ErrorCode {
	String getCode();
	HttpStatus getHttpStatus();
	String getCause();
}
