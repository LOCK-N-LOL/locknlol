package com.locknlol.coukie.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Table(name = "images")
public class Image {
	private String full;
	private String sprite;
	private String group;
	private Long x;
	private Long y;
	private Long w;
	private Long h;
}
