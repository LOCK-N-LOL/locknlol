package com.locknlol.coukie.controller.riot;

import com.locknlol.coukie.domain.riot.basicinfo.SummonerInfoFacade;
import com.locknlol.coukie.domain.riot.match.info.MatchBasicInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Oscar on 2017. 6. 24..
 */
@Slf4j
@RestController
public class SummonerBasicInfoController {
	@Autowired
	private SummonerInfoFacade summonerInfoFacade;

	@RequestMapping(value = "/summoner/main/{summonerName}", method = RequestMethod.GET)
	public List<MatchBasicInfoDto> getBasicInfos(@PathVariable String summonerName) {
		return summonerInfoFacade.recentMatchBasicInfos(summonerName);
	}
}
