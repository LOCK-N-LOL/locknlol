package com.locknlol.coukie.adapter.riot.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Haylie
 * @since 2017. 5. 29..
 */

@Getter
@Setter
public class PlayerDto {
    private String currentPlatformId;
    private String summonerName;
    private String matchHistoryUri;
    private String platformId;
    private Long currentAccountId;
    private Integer profileIcon;
    private Long summonerId;
    private Long accountId;
}
