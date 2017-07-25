package com.locknlol.coukie.controller.riot.summoner.profile;

import com.locknlol.coukie.adapter.riot.common.RiotAdapterService;
import com.locknlol.coukie.adapter.riot.dto.LeaguePositionDto;
import com.locknlol.coukie.domain.riot.summoner.RiotSummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kev on 2017. 7. 17.
 */
@Controller
@RequestMapping("/summoner/profile")
public class SummonerProfileController {

	private final RiotAdapterService riotAdapterService;

	private final RiotSummonerService riotSummonerService;

	@Autowired
	public SummonerProfileController(RiotAdapterService riotAdapterService, RiotSummonerService riotSummonerService) {
		this.riotAdapterService = riotAdapterService;
		this.riotSummonerService = riotSummonerService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String view() {
		return "/league/position";
	}

	@RequestMapping(value = "/league/position", method = RequestMethod.GET)
	@ResponseBody
	public List<LeaguePositionDto> getAllLeaguesBySummonerId(@RequestParam String summonerName) {
		Long summonerId = riotSummonerService.getSummonerIdBySummonerName(summonerName);
		return riotAdapterService.getLeaguePosition(summonerId);
	}
}
