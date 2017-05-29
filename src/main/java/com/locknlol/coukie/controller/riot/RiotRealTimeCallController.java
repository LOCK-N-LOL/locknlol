package com.locknlol.coukie.controller.riot;

import com.locknlol.coukie.adapter.riot.response.LolRecentMatchesResponse;
import com.locknlol.coukie.adapter.riot.response.LolSummonerByNameResponse;
import com.locknlol.coukie.domain.riot.RiotRealTimeCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Oscar on 2017. 5. 27..
 */
@RestController
@RequestMapping("/api")
public class RiotRealTimeCallController {

	@Autowired
	private RiotRealTimeCallService riotRealTimeCallService;

	@RequestMapping(value = "/summoner/by-name/{name}", method = RequestMethod.GET)
	public LolSummonerByNameResponse findSummonerByName(@PathVariable String name) throws Exception{
		return riotRealTimeCallService.findSummonerByName(name);
	}

	@RequestMapping(value = "/recent/matches/{name}", method = RequestMethod.GET)
	public LolRecentMatchesResponse getRecentMatches(@PathVariable String name) throws Exception {
		return riotRealTimeCallService.getRecentMatches(name);
	}

	@RequestMapping(value = "/matches/{matchId}", method = RequestMethod.GET)
	public  void getMatchByMatchId(@PathVariable Long matchId) throws Exception {

	}
}
