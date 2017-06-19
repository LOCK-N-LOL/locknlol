package com.locknlol.coukie.adapter.riot.dto.items;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 4.
 */
@Data
public class ItemListDto {
    private Map<String, ItemDto> data;
    private List<ItemTreeDto> tree;
    private List<GroupDto> groups;
    private String type;
    private String version;
}
