package com.locknlol.coukie.adapter.riot;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Oscar on 2017. 6. 4..
 */
public class ApiKeyGenerator {

	public static ApiKeyGenerator instance;
	private Queue<String> queue;

	private int count;

	private static final String MUMU_KEY = "98930870-11b9-4d43-ad3d-2c629c631a38";
	private static final String KEV_KEY = "RGAPI-2056f7ec-01fa-4edc-a7d7-d618d663db74";
	private static final String JBAM_KEY = "RGAPI-57969e80-fe51-4674-bfc7-14c0cdd69617";

	private static final int EACH_KEY_LIMIT_CALL = 50;

	private ApiKeyGenerator() {
		queue = new LinkedList<>();
		queue.add(MUMU_KEY);
		queue.add(KEV_KEY);
		queue.add(JBAM_KEY);
	}

	public static ApiKeyGenerator getInstance() {
		if (instance == null) {
			instance = new ApiKeyGenerator();
		}
		return instance;
	}

	public String getApiKey() {
		if(getCount() >= EACH_KEY_LIMIT_CALL) {
			keyChange();
		}
		increment();
		return queue.peek();
	}

	private void keyChange() {
		String currentKey = queue.poll();
		queue.add(currentKey);
		setZero();
	}

	private void increment() {
		synchronized (this) {
			++count;
		}
	}

	private int getCount() {
		return count;
	}

	private void setZero() {
		synchronized (this) {
			count = 0;
		}
	}

	//테스트 코드 접근용
	protected Queue<String> getQueue() {
		return queue;
	}
}
