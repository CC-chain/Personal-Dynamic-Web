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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRS_PROJECTS")
@Data
@NoArgsConstructor
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
	
}
