package com.locknlol.coukie.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@Service
public class UserFindService {

	@Autowired
	private UserRepository repository;

	public User findBySummonerId(String summonerId) {
		return repository.findBySummonerId(summonerId);
	}
}
