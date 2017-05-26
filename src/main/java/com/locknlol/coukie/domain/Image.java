package com.locknlol.coukie.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by kev on 2017. 5. 25.
 */
@Data
@Entity
@Table(name = "images")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String full;
	private String sprite;
	private String group;
	private Long x;
	private Long y;
	private Long w;
	private Long h;
}
