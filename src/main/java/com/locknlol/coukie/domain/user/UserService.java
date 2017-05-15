package com.locknlol.coukie.domain.user;

import com.locknlol.coukie.domain.Tier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@Service
public class UserService {
	@Autowired
	private UserFindService userFindService;
	@Autowired
	private UserSaveService userSaveService;
	@Autowired
	private UserRepositoryImpl userRepositoryImpl;

	private static final String ID = "system";

	public User saveMember(User user) {
		if(userFindService.findBySummonerId(user.getSummonerId()) == null) {
			user.setCreatedBy(ID);
			user.setTier(Tier.BRONZE);
			userSaveService.saveMember(user);
		}
		return null;
	}

	public List<User> findByTier(Tier tier) {
		return userRepositoryImpl.QFindSameTierUser(tier);
	}
}
