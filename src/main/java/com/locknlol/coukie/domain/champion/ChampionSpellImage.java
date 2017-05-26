package com.locknlol.coukie.domain.champion;

import com.locknlol.coukie.domain.Image;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kev on 2017. 5. 25.
 */
@Entity
@Table(name = "champion_spell_images")
public class ChampionSpellImage extends Image {
}
