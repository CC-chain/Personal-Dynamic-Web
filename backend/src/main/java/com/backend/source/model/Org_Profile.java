package com.backend.source.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ORG_PROFILE")
@Data
@NoArgsConstructor
public class Org_Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_PROFILE_ID")
	private long Id;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "DOB")
	private Date DateOfBirth;
	
	@Column(name = "LOCATION")
	private String Location;
	
	@Column(name="ABOUT" , length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String About;

}
