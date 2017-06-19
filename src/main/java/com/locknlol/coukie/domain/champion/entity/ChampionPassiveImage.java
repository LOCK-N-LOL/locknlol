package com.locknlol.coukie.domain.champion.entity;

import com.locknlol.coukie.domain.common.entity.Image;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by kev on 2017. 5. 25.
 */
@Entity
@DiscriminatorValue("ChampionPassive")
public class ChampionPassiveImage extends Image {
}
