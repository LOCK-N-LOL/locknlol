package com.locknlol.coukie.adapter.riot.dto.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.locknlol.coukie.adapter.riot.dto.EntityConvertable;
import com.locknlol.coukie.domain.item.entity.Item;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 4.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto implements EntityConvertable<Item>{
    private List<String> tags;
    private String id;
    private String sanitizedDescription;
    private String plaintext;
    private Map<String, Boolean> maps;
    private String description;
    private InventoryDataStatsDto stats;
    private String name;
    private List<String> into;
    private ItemImageDto image;
    private String colloq;
    private GoldDto gold;
    // Optional values
    private Boolean hideFromAll;
    private Boolean inStore;
    private Integer specialRecipe;
    private Map<String, String> effect;
    private String requiredChampion;
    private List<String> from;
    private String group;
    private Boolean consumeOnFull;
    private Boolean consumed;
    private Integer depth;
    private Integer stacks;

    @Override
    public Item getNewEntity() {
        return new Item();
    }
}
