package com.locknlol.coukie.adapter.riot;

/**
 * Created by Oscar on 2017. 5. 26..
 */
public interface RiotRequest<Response> {

	RiotApiUrl getUrl();
	Class<Response> getResponseType();

	static <Response> RiotRequest<Response> of(RiotApiUrl url, Class<Response> responseType) {
		return new RiotRequest<Response>() {
			@Override
			public RiotApiUrl getUrl() {
				return url;
			}

			@Override
			public Class<Response> getResponseType() {
				return responseType;
			}
		};
	}
}
