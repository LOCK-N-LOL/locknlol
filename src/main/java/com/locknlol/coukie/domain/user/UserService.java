package com.locknlol.coukie.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@Service
public class UserService {
	@Autowired
	private UserFindService userFindService;
	@Autowired
	private UserSaveService userSaveService;

	private static final String ID = "system";

	public User saveMember(User user) {
		if(userFindService.findBySummonerId(user.getSummonerId()) == null) {
			user.setCreatedBy(ID);
			userSaveService.saveMember(user);
		}
		return null;
	}
}
