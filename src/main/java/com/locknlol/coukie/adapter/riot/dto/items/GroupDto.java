package com.locknlol.coukie.adapter.riot.dto.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 4.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDto {
    private String key;
    private String maxGroupOwnable;
}
