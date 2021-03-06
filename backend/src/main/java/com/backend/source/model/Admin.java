package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADMINS")
@Data
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMIN_ID")
	private long id;
	
	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;
}
