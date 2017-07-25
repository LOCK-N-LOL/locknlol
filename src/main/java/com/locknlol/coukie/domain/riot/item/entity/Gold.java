package com.locknlol.coukie.domain.riot.item.entity;

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
public class Gold {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String base;
	private String total;
	private String sell;
	private String purchasable;
}
