package com.locknlol.coukie.adapter;

import com.locknlol.coukie.adapter.parser.RiotParser;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotUrlBuilder;
import com.locknlol.coukie.adapter.riot.RiotRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Oscar on 2017. 5. 25..
 */
@Slf4j
@Component
public class RiotAdapter extends Adapter {
	@Autowired
	private RiotParser riotParser;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RiotUrlBuilder urlBuilder;

	public <Res> Res get(RiotRequest<Res> request, RiotApiUrl apiUrl) throws Exception {
		return get(request, apiUrl, Collections.emptyMap(), Collections.emptyMap());
	}

	public <Res> Res get(RiotRequest<Res> request, RiotApiUrl apiUrl, Map<String, Object> requestParam) throws Exception {
		return get(request, apiUrl, requestParam, Collections.emptyMap());
	}

	/**
	 *
	 * @param request 어떠한 요청인지
	 * @param apiUrl 요청에 해당하는 url
	 * @param requestParam api Url의 Path Variable에 들어갈 param, 네이밍 맞추어 줘야함
	 * @param getParam url 뒤에 붙을 param   ex) ?name=oscar&team=travel
	 * @param <Res> response
	 * @return
	 * @throws Exception
	 */
	public <Res> Res get(RiotRequest<Res> request, RiotApiUrl apiUrl, Map<String, Object> requestParam, Map<String, Object> getParam)
		throws Exception {
		String url = urlBuilder.buildUrl(apiUrl, getParam);
		log.info("request url: {}", url);
		String s = restTemplate.getForObject(url, String.class, requestParam);
		log.info("request: {}", s);
		return riotParser.parse(s, request.getResponseType());
	}
}
