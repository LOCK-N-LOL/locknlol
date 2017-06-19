package com.locknlol.coukie.adapter.riot;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Oscar on 2017. 6. 4..
 */
public class ApiKeyGeneratorTest {

	private ApiKeyGenerator apiKeyGenerator = ApiKeyGenerator.getInstance();
	private static final Integer KEY_NUM = 3;
	private static final Integer EACH_KEY_LIMIT_CALL = 50;

	@Test
	public void queueSizeTest() {
		assertThat(apiKeyGenerator.getQueue().size(), is(KEY_NUM));
	}

	@Test
	public void key_change_when_call_more_than_50() {
		String firstKey = apiKeyGenerator.getApiKey();
		for (int i = 0; i < EACH_KEY_LIMIT_CALL; ++i) {
			apiKeyGenerator.getApiKey();
		}
		String secondKey = apiKeyGenerator.getApiKey();
		assertNotEquals(firstKey, secondKey);
	}

	@Test
	public void same_key_return_for_50_times() {
		String key = apiKeyGenerator.getApiKey();
		for(int i = 1; i < EACH_KEY_LIMIT_CALL; ++i) {
			assertEquals(key, apiKeyGenerator.getApiKey());
		}
	}

	@Test
	public void return_to_first_key() {
		String key = apiKeyGenerator.getApiKey();
		for(int i = 1; i < EACH_KEY_LIMIT_CALL * KEY_NUM; ++i) {
			apiKeyGenerator.getApiKey();
		}
		assertEquals(key, apiKeyGenerator.getApiKey());
	}
}