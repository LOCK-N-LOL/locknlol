package com.locknlol.coukie.controller.riot;

import com.locknlol.coukie.adapter.riot.response.RiotLeaguesBySummonerIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchByMatchIdResponse;
import com.locknlol.coukie.adapter.riot.response.RiotMatchResponse;
import com.locknlol.coukie.adapter.riot.response.RiotSummonerByNameResponse;
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

	@RequestMapping(value = "/summoner/by-name/{summonerName}", method = RequestMethod.GET)
	public RiotSummonerByNameResponse findSummonerByName(@PathVariable String summonerName) {
		return riotRealTimeCallService.getSummonerByName(summonerName);
	}

	@RequestMapping(value = "/recent/matches/{summonerName}", method = RequestMethod.GET)
	public RiotMatchResponse getRecentMatches(@PathVariable String summonerName) {
		return riotRealTimeCallService.getRecentMatches(summonerName);
	}

	@RequestMapping(value = "/matches/{matchId}", method = RequestMethod.GET)
	public RiotMatchByMatchIdResponse getMatchByMatchId(@PathVariable Long matchId) {
		return riotRealTimeCallService.getMatchByMatchId(matchId);
	}

	@RequestMapping(value = "/all/matches/{summonerName}", method = RequestMethod.GET)
	public RiotMatchResponse getAllMatches(@PathVariable String summonerName) {
		return riotRealTimeCallService.getAllMatches(summonerName);
	}

	@RequestMapping(value = "/leagues/by-summoner/{summonerId}" , method = RequestMethod.GET)
	public RiotLeaguesBySummonerIdResponse getAllLeaguesBySummonerId(@PathVariable Long summonerId) {
		return riotRealTimeCallService.getLeaguesBySummonerId(summonerId);
	}
}
