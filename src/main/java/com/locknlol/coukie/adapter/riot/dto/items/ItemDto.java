package com.locknlol.coukie.adapter.riot.dto.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 4.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
    private List<String> tags;
    private String id;
    private String sanitizedDescription;
    private String plaintext;
    private Map<String, Boolean> maps;
    private String description;
    /**
     * {@link com.locknlol.coukie.adapter.riot.dto.items.InventoryDataStatsDto}
     */
    private Map<String, Double> stats;
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
}
