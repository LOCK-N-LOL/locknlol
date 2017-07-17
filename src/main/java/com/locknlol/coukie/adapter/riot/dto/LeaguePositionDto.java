package com.locknlol.coukie.adapter.riot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kev on 2017. 7. 17.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguePositionDto {
	private String rank;
	private String queueType;
	private boolean hotStreak;
	private MiniSeriesDto miniSeries;
	private int wins;
	private boolean veteran;
	private int losses;
	private String playerOrTeamId;
	private String leagueName;
	private String playerOrTeamName;
	private boolean inactive;
	private boolean freshBlood;
	private String tier;
	private int leaguePoints;
}
