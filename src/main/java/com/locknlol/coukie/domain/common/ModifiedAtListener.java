package com.locknlol.coukie.domain.common;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Created by Oscar on 2017. 5. 11..
 */
public class ModifiedAtListener {
	@PreUpdate
	@PrePersist
	public void setModifiedAt(final Object entity) {
		((Modifiable) entity).setModifiedAt(DateUtils.asDate(LocalDateTime.now()));
	}
}

