package com.locknlol.coukie.adapter.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Oscar on 2017. 5. 26..
 */
public interface Parser {
	ObjectMapper mapper = new ObjectMapper();

	default <T> T parse(String responseJson, Class<T> responseClazz) throws IOException {
		T obj = mapper.readValue(responseJson, responseClazz);
		return obj;
	}
}
