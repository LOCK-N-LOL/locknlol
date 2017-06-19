package com.locknlol.coukie.adapter.riot.response;

import com.locknlol.coukie.adapter.riot.dto.MatchReferenceDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Oscar on 2017. 5. 27..
 */
@Getter
@Setter
public class RiotMatchResponse {

	private List<MatchReferenceDto> matches;
	private Integer totalGames;
	private Integer startIndex;
	private Integer endIndex;
}
