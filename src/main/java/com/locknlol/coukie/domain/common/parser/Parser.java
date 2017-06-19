package com.locknlol.coukie.domain.common.parser;

import java.io.IOException;

/**
 * Created by Oscar on 2017. 5. 26..
 */
public interface Parser {
	<T> T parse(String targetData, Class<T> targetClazz) throws IOException;
}
