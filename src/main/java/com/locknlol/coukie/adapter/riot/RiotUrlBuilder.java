package com.locknlol.coukie.adapter.riot;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * Created by Oscar on 2017. 5. 27..
 */
@Component
public class RiotUrlBuilder {

	private static final String DOMAIN = "https://kr.api.riotgames.com";
	private static final String API_KEY = "api_key";

	private static final ApiKeyGenerator apiKeyGenerator = ApiKeyGenerator.getInstance();

	//temp
	private static final String apiKeyForDevelop = "RGAPI-c98bfd7c-ca78-4ea7-a864-bfe81c88bf7f";

	public String buildUrl(RiotApiUrl url, Map<String, Object> requestParam) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(DOMAIN + url.getUrl());
		//builder.queryParam(API_KEY, apiKeyGenerator.getApiKey());
		builder.queryParam(API_KEY, apiKeyForDevelop);

		requestParam.entrySet().forEach(
			each -> builder.queryParam(each.getKey(), each.getValue())
		);
		return builder.build().toString();
	}
}
