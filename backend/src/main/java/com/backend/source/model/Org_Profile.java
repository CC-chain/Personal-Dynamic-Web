package com.backend.source.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "ORG_PROFILE")
public class Org_Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_PROFILE_ID")
	private long Profile_Id;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "DOB")
	private Date DateOfBirth;
	
	@Column(name = "LOCATION")
	private String Location;
	
	@Column(name="ABOUT" , length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String About;
	

	//--------------
	// PUBLIC METHODS
	//--------------
	public Org_Profile() {
	}
	
	public long getProfile_id() {
		return Profile_Id;
	}

	public void setProfile_id(long profile_id) {
		Profile_Id = profile_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		About = about;
	}
	
}
