package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_ABILITIES")
public class Org_Abilities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_ABILITIES_ID")
	private long Abilities_Id;
	
	@Column(name = "NAME")
	private String Name;
	
	@Column(name = "RATE")
	private int Rate;
	
	@Column(name = "TYPE")
	private String Type;

	
	//--------------
	// PUBLIC METHODS
	//--------------


	public Org_Abilities() {
	}
	
	public long getAbilities_Id() {
		return Abilities_Id;
	}


	public void setAbilities_Id(long abilities_Id) {
		Abilities_Id = abilities_Id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getRate() {
		return Rate;
	}


	public void setRate(int rate) {
		Rate = rate;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}
	
}
