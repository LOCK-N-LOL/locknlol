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
public enum RiotErrorCode implements ErrorCode {

	SUMMONER_NOT_FOUND("summoner not found", HttpStatus.NOT_FOUND, "summonerName에 해당하는 유저가 존재하지 않습니다."),
	API_CALL_FAIL("api call fail", HttpStatus.EXPECTATION_FAILED, "정보를 요청하던 중 알 수 없는 문제가 발생했습니다.");

	private final String code;
	private final HttpStatus httpStatus;
	private final String cause;
}
