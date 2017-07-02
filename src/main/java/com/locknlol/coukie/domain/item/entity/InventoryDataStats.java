package com.locknlol.coukie.domain.item.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kev on 2017. 7. 2.
 */
@Entity
@Getter
@Setter
public class InventoryDataStats {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double percentCritDamageMod;
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
}
