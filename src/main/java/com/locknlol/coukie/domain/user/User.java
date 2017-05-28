package com.locknlol.coukie.domain.user;

import com.locknlol.coukie.domain.common.CommonModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Oscar on 2017. 5. 10..
 */

@Data
@Entity
@Table(name = "l_user")
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class User extends CommonModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", nullable = false)
	private Long id;

	@Column(name = "summonerId", nullable = false)
	private String summonerId;

	@Column(name = "password", nullable = false)
	private String password;

	@Enumerated(value = EnumType.STRING)
	private Tier tier;
}
