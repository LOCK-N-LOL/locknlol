package com.locknlol.coukie.domain.riot.match.info;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 2017. 6. 25..
 */
@Getter
@Setter
public class MatchBasicInfoDto {
	private Integer championId;
	private Integer kills;
	private Integer deaths;
	private Integer assists;
	private List<Integer> items = new ArrayList<>();
	private Integer champLevel;
	private Long duration;
	private List<ParticipantsDto> participants;

	private static final int MINUTE = 60;
	private static final String MINUTES = "분";
	private static final String SECONDS = "초";

	private double getAverageScore() {
		return ((double) (kills + assists)) / (double) deaths;
	}

	public void addItems(Integer itemId) {
		this.items.add(itemId);
	}

	public String getTotalGameTime() {
		long minutes = duration / MINUTE;
		long seconds = duration % MINUTE;
		return minutes + MINUTES + seconds + SECONDS;
	}
}
