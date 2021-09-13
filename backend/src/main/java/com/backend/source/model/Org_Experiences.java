package com.backend.source.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_EXPERIENCES")
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

	
	
	//--------------
	// PUBLIC METHODS
	//--------------
	
	public Org_Experiences() {
	}
	
	public long getExperience_Id() {
		return Experience_Id;
	}

	public void setExperience_Id(long experience_Id) {
		Experience_Id = experience_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDate_First() {
		return Date_First;
	}

	public void setDate_First(Date date_First) {
		Date_First = date_First;
	}

	public Date getDate_Last() {
		return Date_Last;
	}

	public void setDate_Last(Date date_Last) {
		Date_Last = date_Last;
	}

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getWebSite() {
		return WebSite;
	}

	public void setWebSite(String webSite) {
		WebSite = webSite;
	}

	
}
