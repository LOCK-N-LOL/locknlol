package com.locknlol.coukie.controller;

import com.locknlol.coukie.domain.riot.champion.ChampionService;
import com.locknlol.coukie.domain.riot.champion.entity.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Haylie
 * @since 2017. 5. 16..
 */

@Controller
@RequestMapping("/staticDataV3")
public class StaticDataV3Controller {

	private final ChampionService championService;

	@Autowired
	public StaticDataV3Controller(ChampionService championService) {
		this.championService = championService;
	}

	@RequestMapping("/getChampionImage")
	@ResponseBody
	private String getChampionImage(String id) {
		Champion one = championService.getChampion(Long.parseLong(id));
		return one.getImage().getImgUrl();
	}

}
