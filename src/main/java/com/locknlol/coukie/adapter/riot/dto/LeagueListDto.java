package com.locknlol.coukie.adapter.riot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Haylie
 * @since 2017. 6. 5..
 */
@Getter
@Setter
public class LeagueListDto {
    private String tier;
    private String queue;
    private String name;
    private List<LeagueItemDto> entries;
}
