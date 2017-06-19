package com.locknlol.coukie.adapter.riot;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oscar on 2017. 5. 28..
 */
public class RiotAdapterParameter {

	public static Map<String, Object> getSummonerNameParam(String summonerName) {
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("summonerName", summonerName);
		return requestParam;
	}

	public static Map<String, Object> getAccountIdParam(Long accountId) {
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("accountId", accountId);
		return requestParam;
	}

	public static Map<String, Object> getMatchIdParam(Long matchId) {
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("matchId", matchId);
		return requestParam;
 	}

	public static Map<String, Object> getSummonerId(Long summonerId) {
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("summonerId", summonerId);
		return requestParam;
	}
}
