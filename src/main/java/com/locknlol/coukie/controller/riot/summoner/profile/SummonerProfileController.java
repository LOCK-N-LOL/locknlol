package com.locknlol.coukie.controller.riot.summoner.profile;

import com.locknlol.coukie.adapter.riot.RiotAdapterService;
import com.locknlol.coukie.adapter.riot.dto.LeaguePositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kev on 2017. 7. 17.
 */
@Controller
@RequestMapping("/summoner/profile")
public class SummonerProfileController {

	private final RiotAdapterService riotAdapterService;

	@Autowired
	public SummonerProfileController(RiotAdapterService riotAdapterService) {
		this.riotAdapterService = riotAdapterService;
	}

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String view() {
		return "/summoner/profile/league_positions";
	}

	@RequestMapping(value = "/league/position" , method = RequestMethod.GET)
	@ResponseBody
	public List<LeaguePositionDto> getAllLeaguesBySummonerId(@RequestParam Long summonerId) {
		return riotAdapterService.getLeaguePosition(summonerId);
	}
}
