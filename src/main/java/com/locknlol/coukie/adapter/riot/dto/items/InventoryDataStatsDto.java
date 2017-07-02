package com.locknlol.coukie.adapter.riot.dto.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.locknlol.coukie.adapter.riot.dto.EntityConvertable;
import com.locknlol.coukie.domain.item.entity.InventoryDataStats;
import lombok.Data;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 4.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryDataStatsDto implements EntityConvertable<InventoryDataStats> {
    @JsonProperty("PercentCritDamageMod")
    private Double percentCritDamageMod;
    @JsonProperty("PercentSpellBlockMod")
    private Double percentSpellBlockMod;
    private Double percentHPRegenMod;
    private Double percentMovementSpeedMod;
    private Double flatSpellBlockMod;
    private Double flatCritDamageMod;
    private Double flatEnergyPoolMod;
    private Double percentLifeStealMod;
    private Double flatMPPoolMod;
    private Double flatMovementSpeedMod;
    private Double percentAttackSpeedMod;
    private Double flatBlockMod;
    private Double percentBlockMod;
    private Double flatEnergyRegenMod;
    private Double percentSpellVampMod;
    private Double flatMPRegenMod;
    private Double percentDodgeMod;
    private Double flatAttackSpeedMod;
    private Double flatArmorMod;
    private Double flatHPRegenMod;
    private Double percentMagicDamageMod;
    private Double percentMPPoolMod;
    private Double flatMagicDamageMod;
    private Double percentMPRegenMod;
    private Double percentPhysicalDamageMod;
    private Double flatPhysicalDamageMod;
    private Double percentHPPoolMod;
    private Double percentArmorMod;
    private Double percentCritChanceMod;
    private Double percentEXPBonus;
    private Double flatHPPoolMod;
    private Double flatCritChanceMod;
    private Double flatEXPBonus;

    @Override
    public InventoryDataStats getNewEntity() {
        return new InventoryDataStats();
    }

}
