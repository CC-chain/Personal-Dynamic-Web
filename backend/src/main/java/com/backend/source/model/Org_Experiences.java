package com.backend.source.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORG_EXPERIENCES")
@Data
@NoArgsConstructor
public class Org_Experiences {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	@Column(name = "ORG_EXPERIENCE_ID")
	private long Experience_Id;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "DATE_FIRST")
	private Date Date_First;
	
	@Column(name = "DATE_LAST")
	private Date Date_Last;
	
	@Column(name = "INFO")
	private String Info;
	
	@Column(name = "LOCATION")
	private String Location;
	
	@Column(name = "TYPE")
	private String Type;
	
	@Column(name = "WEBSITE")
	private String WebSite;

}
