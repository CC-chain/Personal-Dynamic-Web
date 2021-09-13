package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "ORG_PROJECTS")
public class Org_Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Projects_Id;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "INFO", length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String Info;
	
	@Column(name = "URL")
	private String Url;
	
	@Column(name = "ABOUT", length = 65535, columnDefinition="TEXT")
	@Type(type="text")
	private String About;

	//--------------
	// PUBLIC METHODS
	//--------------
	
	public Org_Projects() {
	}
	
	public long getProjects_Id() {
		return Projects_Id;
	}

	public void setProjects_Id(long projects_Id) {
		Projects_Id = projects_Id;
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

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		About = about;
	}
	
	
}
