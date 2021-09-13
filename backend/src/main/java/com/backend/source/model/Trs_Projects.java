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
@Table(name = "TRS_PROJECTS")
public class Trs_Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_PROJECT_ID")
	private long Project_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_PROJECT_ID", foreignKey = @ForeignKey(name = "ORG_PROJECT_ID_FK"))
	private Org_Projects Org_Projects_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "PROJECTS_LANG_ID_FK"))
	private Language Lang_Id;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "INFO", length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String Info;
	
	@Column(name = "ABOUT", length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String About;

	//--------------
	// PUBLIC METHODS
	//--------------
	

	public Trs_Projects() {
	}
	
	public long getProject_Id() {
		return Project_Id;
	}

	public void setProject_Id(long project_Id) {
		Project_Id = project_Id;
	}

	public Org_Projects getOrg_Projects_Id() {
		return Org_Projects_Id;
	}

	public void setOrg_Projects_Id(Org_Projects org_Projects_Id) {
		Org_Projects_Id = org_Projects_Id;
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

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		About = about;
	}

}
