package com.locknlol.coukie.adapter.riot.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Oscar on 2017. 5. 27..
 */
@Getter
@Setter
public class MatchReferenceDto {
	private String lane;
	private Long gameId;
	private Integer champion;
	private String platformId;
	private Integer season;
	private Integer queue;
	private String role;
	private long timestamp;
}
