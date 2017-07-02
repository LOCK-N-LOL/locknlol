package com.locknlol.coukie.adapter.riot.dto;

import com.locknlol.coukie.domain.common.entity.Image;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @author jinie@coupang.com
 * @since 2017. 5. 29.
 */
@Getter
@Setter
public abstract class ImageDto<ImageEntity extends Image> {
	private String full;
	private String sprite;
	private String group;
	private Long x;
	private Long y;
	private Long w;
	private Long h;


	public abstract ImageEntity getNewEntity();

	public ImageEntity copiedEntity() {
		ImageEntity entity = getNewEntity();
		BeanUtils.copyProperties(this, entity);
		return entity;
	}


}
