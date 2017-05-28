package com.locknlol.coukie.domain.user;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Oscar on 2017. 5. 15..
 */
@Repository
public class UserRepositoryImpl extends QueryDslRepositorySupport implements CustomUserRepository {

	public UserRepositoryImpl() {
		super(User.class);
	}

	QUser qUser = QUser.user;

	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}

	public void queryDsl() {
	}

	@Override
	public List<User> QFindSameTierUser(Tier tier) {
		return from(qUser)
			.where(qUser.tier.eq(tier))
			.fetch();
	}
}
