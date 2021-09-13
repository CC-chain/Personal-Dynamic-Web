package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LANGUAGE")
public class Language {

	@Id
	@Column(name = "LANG_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Lang_Id;
	
	@Column(name = "NAME")
	private String Name;

	//--------------
	// PUBLIC METHODS
	//--------------
	
	public Language() {
		
	}
	
	public long getLang_Id() {
		return Lang_Id;
	}


	public void setLang_Id(long lang_Id) {
		Lang_Id = lang_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
