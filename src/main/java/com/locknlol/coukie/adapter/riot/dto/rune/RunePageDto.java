package com.locknlol.coukie.adapter.riot.dto.rune;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@Getter
@Setter
public class RunePageDto {
	/**
	 * 해당 페이지가 현재의 페이지인지 여부
	 */
	private Boolean current;

	private Set<RuneSlotDto> slots;

	@JsonProperty(value = "name")
	private String runePageName;

	@JsonProperty(value = "id")
	private Long runePageId;
}
