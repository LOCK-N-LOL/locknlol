package com.locknlol.coukie.domain.riot.match.info;

import lombok.*;

/**
 * Created by Oscar on 2017. 6. 25..
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantsDto {
	private Integer championId;
	private String summonerName;
}
