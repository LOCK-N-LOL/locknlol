package com.locknlol.coukie.domain.member;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Oscar on 2017. 5. 10..
 */

@Data
@Entity
@Table(name = "member")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "memberId", nullable = false)
	private Long id;

	@Column(name = "summonerId", nullable = false)
	private String summonerId;

	@Column(name = "password", nullable = false)
	private String password;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date modifiedAt;
}
