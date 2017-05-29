package com.locknlol.coukie.domain.riot.exception;

import com.locknlol.coukie.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Created by Oscar on 2017. 5. 28..
 */
@Getter
@RequiredArgsConstructor
public enum LoLErrorCode implements ErrorCode {

	SUMMONER_NOT_FOUND("summoner not found", HttpStatus.NOT_FOUND, "summonerName에 해당하는 유저가 존재하지 않습니다.");

	private final String code;
	private final HttpStatus httpStatus;
	private final String cause;
}
