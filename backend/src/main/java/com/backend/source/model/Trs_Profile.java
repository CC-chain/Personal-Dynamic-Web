package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "TRS_PROFILE")
public class Trs_Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_PROFILE_ID")
	private long Profile_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_PROFILE_ID", foreignKey = @ForeignKey(name = "ORG_PROFILE_ID_FK"))
	private Org_Profile Org_Profile_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "PROFILE_LANG_ID_FK"))
	private Language Lang_Id;

	@Column(name = "NAME")
	private String Name;

	@Column(name = "LOCATION")
	private String Location;

	@Column(name = "ABOUT", length = 65535, columnDefinition = "TEXT")
	@Type(type = "text")
	private String About;

	// --------------
	// PUBLIC METHODS
	// --------------
	
	public Trs_Profile() {
	}

	public long getProfile_Id() {
		return Profile_Id;
	}

	public void setProfile_Id(long profile_Id) {
		Profile_Id = profile_Id;
	}

	public Org_Profile getOrg_Profile_Id() {
		return Org_Profile_Id;
	}

	public void setOrg_Profile_Id(Org_Profile org_Profile_Id) {
		Org_Profile_Id = org_Profile_Id;
	}

	public Language getLang_Id() {
		return Lang_Id;
	}

	public void setLang_Id(Language lang_Id) {
		Lang_Id = lang_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
