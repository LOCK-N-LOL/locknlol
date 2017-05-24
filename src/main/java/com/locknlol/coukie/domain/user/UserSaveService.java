package com.locknlol.coukie.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 5. 11..
 */
@Service
public class UserSaveService {
	@Autowired
	private UserRepository repository;

	public User saveMember(User user) {
		return repository.save(user);
	}
}
