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


@Entity
@Table(name = "TRS_EXPERIENCES")
public class Trs_Experiences {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_EXPERIENCES_ID")
	private long Experiences_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_EXPERIENCES_ID", foreignKey = @ForeignKey(name = "ORG_EXPERIENCES_ID_FK"))
	private Org_Experiences Org_Experiences_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "EXPERIENCES_LANG_ID_FK"))
	private Language Lang_Id;

	@Column(name = "NAME")
	private String Name;

	@Column(name = "INFO")
	private String Info;

	@Column(name = "LOCATION")
	private String Location;

	@Column(name = "TYPE")
	private String Type;
	
	//--------------
	// PUBLIC METHODS
	//--------------
	
	public Trs_Experiences() {
	}

	public long getExperiences_Id() {
		return Experiences_Id;
	}

	public void setExperiences_Id(long experience_Id) {
		Experiences_Id = experience_Id;
	}

	public Org_Experiences getOrg_Experiences_Id() {
		return Org_Experiences_Id;
	}

	public void setOrg_Experiences_Id(Org_Experiences org_Experiences_Id) {
		Org_Experiences_Id = org_Experiences_Id;
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
	
	
}
