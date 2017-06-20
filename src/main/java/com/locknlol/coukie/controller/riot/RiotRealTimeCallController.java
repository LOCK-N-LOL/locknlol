package com.locknlol.coukie.controller.riot;

import com.locknlol.coukie.adapter.riot.dto.RiotLeaguesBySummonerIdDto;
import com.locknlol.coukie.adapter.riot.dto.RiotMatchByMatchIdDto;
import com.locknlol.coukie.adapter.riot.dto.RiotMatchDto;
import com.locknlol.coukie.adapter.riot.dto.RiotSummonerByNameDto;
import com.locknlol.coukie.domain.riot.league.RiotLeagueService;
import com.locknlol.coukie.domain.riot.match.RiotMatchService;
import com.locknlol.coukie.domain.riot.summoner.RiotSummonerService;
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
	RiotSummonerService riotSummonerService;
	@Autowired
	RiotLeagueService riotLeagueService;
	@Autowired
	RiotMatchService riotMatchService;

	@RequestMapping(value = "/summoner/by-name/{summonerName}", method = RequestMethod.GET)
	public RiotSummonerByNameDto findSummonerByName(@PathVariable String summonerName) {
		return riotSummonerService.getSummonerByName(summonerName);
	}

	@RequestMapping(value = "/recent/matches/{summonerName}", method = RequestMethod.GET)
	public RiotMatchDto getRecentMatches(@PathVariable String summonerName) {
		return riotMatchService.getRecentMatches(summonerName);
	}

	@RequestMapping(value = "/matches/{matchId}", method = RequestMethod.GET)
	public RiotMatchByMatchIdDto getMatchByMatchId(@PathVariable Long matchId) {
		return riotMatchService.getMatchByMatchId(matchId);
	}

	@RequestMapping(value = "/all/matches/{summonerName}", method = RequestMethod.GET)
	public RiotMatchDto getAllMatches(@PathVariable String summonerName) {
		return riotMatchService.getAllMatches(summonerName);
	}

	@RequestMapping(value = "/leagues/by-summoner/{summonerId}" , method = RequestMethod.GET)
	public RiotLeaguesBySummonerIdDto getAllLeaguesBySummonerId(@PathVariable Long summonerId) {
		return riotLeagueService.getLeaguesBySummonerId(summonerId);
	}
}
