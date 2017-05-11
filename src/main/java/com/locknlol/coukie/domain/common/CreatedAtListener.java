package com.locknlol.coukie.domain.common;


import javax.persistence.PrePersist;
import java.time.LocalDateTime;

/**
 * Created by Oscar on 2017. 5. 11..
 */

public class CreatedAtListener {
	@PrePersist
	public void setCreatedAt(final Object entity) {
		((Creatable)entity).setCreatedAt(DateUtils.asDate(LocalDateTime.now()));
	}
}
