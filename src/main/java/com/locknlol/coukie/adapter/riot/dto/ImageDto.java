package com.locknlol.coukie.adapter.riot.dto;

import com.locknlol.coukie.domain.common.entity.Image;
import org.springframework.beans.BeanUtils;

/**
 * @author jinie@coupang.com
 * @since 2017. 5. 29.
 */

public abstract class ImageDto<ImageEntity extends Image> {
	protected String full;
	protected String sprite;
	protected String group;
	protected Long x;
	protected Long y;
	protected Long w;
	protected Long h;

	public abstract ImageEntity getNewEntity();

	public ImageEntity copiedEntity() {
		ImageEntity entity = getNewEntity();
		BeanUtils.copyProperties(entity, this);
		return entity;
	}


}
