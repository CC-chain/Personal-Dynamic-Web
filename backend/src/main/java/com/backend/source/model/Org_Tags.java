package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_TAGS")
public class Org_Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_TAGS_ID")
	private long Tags_Id;

	@Column(name = "NAME")
	private String Name;

	// --------------
	// PUBLIC METHODS
	// --------------

	public Org_Tags() {
	}

	public long getTags_Id() {
		return Tags_Id;
	}

	public void setTags_Id(long tags_Id) {
		Tags_Id = tags_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
