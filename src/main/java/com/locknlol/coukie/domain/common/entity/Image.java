package com.locknlol.coukie.domain.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String full;

	private String sprite;

	@Column(name = "imageGroup")
	private String group;

	private Long x;

	private Long y;

	private Long w;

	private Long h;

}
