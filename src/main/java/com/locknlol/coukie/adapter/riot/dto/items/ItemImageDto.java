package com.locknlol.coukie.adapter.riot.dto.items;

import com.locknlol.coukie.adapter.riot.dto.ImageDto;
import com.locknlol.coukie.domain.common.entity.Image;
import com.locknlol.coukie.domain.item.entity.ItemImage;
import lombok.Data;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 4.
 */
@Data
public class ItemImageDto extends ImageDto {
	@Override
	public Image getNewEntity() {
		return new ItemImage();
	}

	@Override
	public String getFull() {
		return "item/" + super.getFull();
	}
}
