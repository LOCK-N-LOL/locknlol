package com.locknlol.coukie.adapter.riot.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Haylie
 * @since 2017. 6. 5..
 */

@Getter
@Setter
public class LeagueItemDto {
    private String rank;
    private boolean hotStreak;
    private MiniSeriesDto miniSeries;
    private int wins;
    private boolean veteran;
    private int losses;
    private String playerOrTeamId;
    private String playerOrTeamName;
    private boolean inactive;
    private boolean freshBlood;
    private int leaguePoints;
}
