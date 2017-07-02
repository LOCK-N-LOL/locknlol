package com.locknlol.coukie.adapter.riot.dto;

import org.springframework.beans.BeanUtils;

/**
 * Created by kev on 2017. 6. 29.
 */
public interface EntityConvertable<EntityType> {
	EntityType getNewEntity();

	default EntityType copiedEntity() {
		EntityType entity = getNewEntity();
		BeanUtils.copyProperties(entity, this);
		return entity;
	}
}
