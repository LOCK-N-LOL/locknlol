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

	public String getWinRate() {
		return String.format("%.2f", ((double) wins / (losses + wins)) * 100.00);
	}

	public String getRankImg() {
		return "https://opgg-static.akamaized.net/images/medals/" + getTier() + "_" + getRankAsNum() + ".png";
	}

	private int getRankAsNum() {
		switch (rank) {
			case "I":
				return 1;
			case "II":
				return 2;
			case "III":
				return 3;
			case "IV":
				return 4;
			case "V":
				return 5;
			default:
				return 0;
		}
	}

	private String getTier() {
		return tier.toLowerCase();
	}
}
