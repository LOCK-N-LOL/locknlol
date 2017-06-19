package com.locknlol.coukie.interfaces.api;

import com.locknlol.coukie.adapter.riot.dto.rune.RiotRunePagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@RestController
@RequestMapping(value = "/api/v1")
public class SummonerAuthApiController {

	@Autowired
	private RiotRealTimeCallService realTimeCallService;

	@RequestMapping("/{summonerName}/rune/pages")
	public RiotRunePagesResponse getRunePagesDetailInfo(@PathVariable String summonerName) {
		return realTimeCallService.getRunePagesDetailInfo(summonerName);
	}
}
