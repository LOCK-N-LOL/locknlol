package com.locknlol.coukie.adapter.riot.dto.items;

import com.locknlol.coukie.adapter.riot.dto.EntityConvertable;
import com.locknlol.coukie.domain.item.entity.Gold;
import lombok.Data;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 4.
 */
@Data
public class GoldDto implements EntityConvertable<Gold>{
    private String base;
    private String total;
    private String sell;
    private String purchasable;

    @Override
    public Gold getNewEntity() {
        return new Gold();
    }
}
