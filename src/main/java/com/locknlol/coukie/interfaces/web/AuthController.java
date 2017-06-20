package com.locknlol.coukie.interfaces.web;

import com.locknlol.coukie.adapter.riot.dto.RiotDto;
import com.locknlol.coukie.domain.riot.auth.SummonerAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@RestController
public class AuthController {

	@Autowired
	private SummonerAuthService summonerAuthService;

	@RequestMapping(value = "/auth/request/{summonerName}", method = RequestMethod.GET)
	public String requestAuthKey(@PathVariable String summonerName) {
		return summonerAuthService.requestAuthKey(summonerName);
	}

	@RequestMapping(value = "/auth/confirm/{summonerName}", method = RequestMethod.GET)
	private RiotDto requestAuthentication(@PathVariable String summonerName) {
		return summonerAuthService.tryAuthentication(summonerName);
	}
}
