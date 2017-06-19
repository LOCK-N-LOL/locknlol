package com.locknlol.coukie.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "member" ,
indexes = @Index(name = "IDX_MEMBER" , columnList = "email"))
@Getter
@Setter
@EqualsAndHashCode(of = { "id" }, callSuper = false)
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;


	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "createdAt", nullable = false)
	private Date createdAt;

	@Column(name = "modifiedAt", nullable = false)
	private Date modifiedAt;
}
