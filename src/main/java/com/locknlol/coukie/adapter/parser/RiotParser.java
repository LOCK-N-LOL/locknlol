package com.locknlol.coukie.adapter.parser;

/**
 * Created by Oscar on 2017. 5. 26..
 */
public class RiotParser implements Parser {

	public static <T> T parse(String responseJson, Class<T> responseClazz) throws Exception {
		T obj = mapper.readValue(responseJson, responseClazz);
		return obj;
	}
}
