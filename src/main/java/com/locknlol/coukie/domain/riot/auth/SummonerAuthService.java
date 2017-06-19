package com.locknlol.coukie.domain.riot.auth;

import com.locknlol.coukie.adapter.riot.dto.rune.RiotRunePagesResponse;
import com.locknlol.coukie.adapter.riot.dto.rune.RunePageDto;
import com.locknlol.coukie.adapter.riot.response.RiotResponse;
import com.locknlol.coukie.domain.riot.rune.RiotRuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Oscar on 2017. 6. 11..
 */
@Service
public class SummonerAuthService {

	@Autowired
	private SummonerAuthFindService summonerAuthFindService;
	@Autowired
	private SummonerAuthSaveService summonerAuthSaveService;
	@Autowired
	private RiotRuneService riotRuneService;

	public String requestAuthKey(String summonerName) {
		if (summonerAuthFindService.checkAuthNotComplete(summonerName));
		SummonerAuth summonerAuth = summonerAuthSaveService.update(summonerName);
		return summonerAuth.getAuthKey();
	}

	public RiotResponse tryAuthentication(String summonerName) {
		SummonerAuth summonerAuth = summonerAuthFindService.findBySummonerName(summonerName);
		RiotRunePagesResponse response = riotRuneService.getRunePagesDetailInfo(summonerName);
		Optional<String> runePageName = findRunePageName(response);

		if (runePageName.get().equals(summonerAuth.getAuthKey())) {
			summonerAuthSaveService.authComplete(summonerName);
			return getRiotResponse(true, "인증에 성공하였습니다.");
		}
		return getRiotResponse(false, "runePageName과 key가 일치하지 않습니다.");
	}

	private Optional<String> findRunePageName(RiotRunePagesResponse response) {
		return Optional.of(response)
			.map(RiotRunePagesResponse::getPages)
			.map(res -> res.stream()
				.filter(RunePageDto::getCurrent)
				.map(RunePageDto::getRunePageName).findAny()).get();
	}

	private RiotResponse getRiotResponse(Boolean success, String message) {
		RiotResponse riotResponse = new RiotResponse();
		riotResponse.setIsSuccess(success);
		riotResponse.setMessage(message);
		return riotResponse;
	}
}
