package com.backend.source.model;

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
@Table(name = "ORG_PROJECTS")
@Data
@NoArgsConstructor
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
}
