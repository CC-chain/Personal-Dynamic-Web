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
@Table(name = "TRS_TAGS")
public class Trs_Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_TAGS_ID")
	private long Tags_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_TAGS_ID", foreignKey = @ForeignKey(name = "ORG_TAGS_ID_FK"))
	private Org_Tags Org_Tags_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "TAGS_LANG_ID_FK"))
	private Language Lang_Id;

	@Column(name = "NAME")
	private String Name;

	// --------------
	// PUBLIC METHODS
	// --------------

	public Trs_Tags() {
	}

	public long getTags_Id() {
		return Tags_Id;
	}

	public void setTags_Id(long tags_Id) {
		Tags_Id = tags_Id;
	}

	public Org_Tags getOrg_Tags_Id() {
		return Org_Tags_Id;
	}

	public void setOrg_Tags_Id(Org_Tags org_Tags_Id) {
		Org_Tags_Id = org_Tags_Id;
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

}
