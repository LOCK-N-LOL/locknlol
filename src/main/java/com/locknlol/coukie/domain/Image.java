package com.locknlol.coukie.domain;

import javax.persistence.Entity;

/**
 * Created by kev on 2017. 5. 25.
 */
@Entity
public class Image {

	public String full;
	public String sprite;
	public String group;
	public Long x;
	public Long y;
	public Long w;
	public Long h;
}
