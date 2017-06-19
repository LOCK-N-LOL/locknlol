package com.locknlol.coukie.adapter;

import com.locknlol.coukie.domain.common.parser.JsonParser;
import com.locknlol.coukie.adapter.riot.RiotRequest;
import com.locknlol.coukie.adapter.riot.RiotUrlBuilder;
import com.locknlol.coukie.domain.riot.exception.RiotErrorCode;
import com.locknlol.coukie.domain.riot.exception.RiotException;
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
	private JsonParser riotParser;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private RiotUrlBuilder urlBuilder;

	public <Res> Res get(RiotRequest<Res> request) throws RuntimeException {
		return get(request, Collections.emptyMap(), Collections.emptyMap());
	}

	public <Res> Res get(RiotRequest<Res> request, Map<String, Object> requestParam) throws RuntimeException {
		return get(request, requestParam, Collections.emptyMap());
	}

	/**
	 *
	 * @param request 어떠한 요청인지
	 * @param requestParam api Url의 Path Variable에 들어갈 param, 네이밍 맞추어 줘야함
	 * @param getParam url 뒤에 붙을 param   ex) ?name=oscar&team=travel
	 * @param <Res> response
	 * @return
	 * @throws Exception
	 */
	public <Res> Res get(RiotRequest<Res> request, Map<String, Object> requestParam, Map<String, Object> getParam) {
		try {
			String url = urlBuilder.buildUrl(request.getUrl(), getParam);
			log.info("request url: {}", url);
			String response = restTemplate.getForObject(url, String.class, requestParam);
			log.info("request: {}", response);
			return riotParser.parse(response, request.getResponseType());
		} catch (Exception e) {
			throw new RiotException(RiotErrorCode.API_CALL_FAIL, e);
		}

	}
}
