package com.locknlol.coukie.domain.champion;

import com.locknlol.coukie.domain.Image;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kev on 2017. 5. 25.
 */
@Entity
@Table(name = "champion_images")
public class ChampionImage extends Image {}
