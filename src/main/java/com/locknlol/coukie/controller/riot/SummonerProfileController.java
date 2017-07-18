package com.locknlol.coukie.controller.riot;

import com.locknlol.coukie.adapter.riot.RiotAdapterService;
import com.locknlol.coukie.adapter.riot.dto.LeaguePositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kev on 2017. 7. 17.
 */
@Controller
public class SummonerProfileController {

	private final RiotAdapterService riotAdapterService;

	@Autowired
	public SummonerProfileController(RiotAdapterService riotAdapterService) {
		this.riotAdapterService = riotAdapterService;
	}

	@RequestMapping(value = "/leagues/by-summoner/{summonerId}" , method = RequestMethod.GET)
	@ResponseBody
	public List<LeaguePositionDto> getAllLeaguesBySummonerId(@PathVariable Long summonerId) {
		return riotAdapterService.getLeaguePosition(summonerId);
	}
}
