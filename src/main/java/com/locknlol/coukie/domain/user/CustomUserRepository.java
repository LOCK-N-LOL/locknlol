package com.locknlol.coukie.domain.user;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Oscar on 2017. 5. 15..
 */
@Repository
public interface CustomUserRepository {
	List<User> QFindSameTierUser(Tier tier);
}
