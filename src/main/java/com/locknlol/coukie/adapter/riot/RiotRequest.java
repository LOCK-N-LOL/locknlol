package com.locknlol.coukie.adapter.riot;

/**
 * Created by Oscar on 2017. 5. 26..
 */
public interface RiotRequest<Response> {

	Class<Response> getResponseType();

	static <RES> RiotRequest<RES> of(Class<RES> responseType) {
		return () -> responseType;
	}
}
