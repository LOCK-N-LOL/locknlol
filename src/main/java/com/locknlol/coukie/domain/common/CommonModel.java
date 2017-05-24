package com.locknlol.coukie.domain.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Oscar on 2017. 5. 11..
 */
@Getter
@Setter
@EntityListeners({CreatedAtListener.class, ModifiedAtListener.class})
@MappedSuperclass
public abstract class CommonModel implements Creatable, Modifiable{

	@Column(name = "createdBy", nullable = false, updatable = false, length = 40)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false, updatable = false, length = 6)
	private Date createdAt;

	@Column(name = "modifiedBy", nullable = false, length = 40)
	private String modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedAt", nullable = false, length = 6)
	private Date modifiedAt;

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		this.modifiedBy = createdBy;
	}
}
