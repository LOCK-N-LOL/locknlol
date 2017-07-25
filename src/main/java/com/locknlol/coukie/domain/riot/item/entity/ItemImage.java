package com.locknlol.coukie.domain.riot.item.entity;

import com.locknlol.coukie.domain.common.entity.Image;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by kev on 2017. 7. 2.
 */
@Entity
@Getter
@Setter
@DiscriminatorValue("Item")
public class ItemImage extends Image {
}
