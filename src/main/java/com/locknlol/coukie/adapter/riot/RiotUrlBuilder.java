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

	public String buildUrl(RiotApiUrl url, Map<String, Object> requestParam) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(DOMAIN + url.getUrl());
		builder.queryParam("api_key", url.getKey());

		requestParam.entrySet().forEach(
			each -> builder.queryParam(each.getKey(), each.getValue())
		);
		return builder.build().toString();
	}
}
