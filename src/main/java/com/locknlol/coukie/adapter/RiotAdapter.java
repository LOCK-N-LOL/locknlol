package com.locknlol.coukie.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Oscar on 2017. 5. 25..
 */
@Slf4j
@Component
public class RiotAdapter implements Adapter{
	@Autowired
	@Qualifier("lockNLolRestTemplate")
	private RestTemplate restTemplate;

	public <Res> Res get() {

		String s = restTemplate.getForObject("url", String.class);

	}


}
