package com.locknlol.coukie.adapter.riot.dto.rune;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@Getter
@Setter
public class RiotRunePagesResponse {
	private Set<RunePageDto> pages;
	private Long summonerId;
}
