package com.locknlol.coukie.domain.member.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "member" ,
indexes = @Index(name = "IDX_MEMBER" , columnList = "email"))
@Getter
@Setter
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", nullable = false)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedAt", nullable = false)
	private Date modifiedAt;

	@Column(name = "useYN", nullable = false)
	private String useYn = "N";
}
