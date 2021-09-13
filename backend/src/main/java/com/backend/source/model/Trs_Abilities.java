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
@Table(name = "TRS_ABILITIES")
public class Trs_Abilities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_ABILITIES_ID")
	private long Abilities_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_ABILITIES_ID", foreignKey = @ForeignKey(name = "ORG_ABILITIES_ID_FK"))
	private Org_Abilities Org_Abilities_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "ABILITIES_LANG_ID_FK"))
	private Language Lang_Id;

	@Column(name = "NAME")
	private String Name;

	@Column(name = "TYPE")
	private String Type;

	// --------------
	// PUBLIC METHODS
	// --------------
	
	public Trs_Abilities() {
	}

	public long getAbilities_Id() {
		return Abilities_Id;
	}

	public void setAbilities_Id(long abilities_Id) {
		Abilities_Id = abilities_Id;
	}

	public Org_Abilities getOrg_Abilities_Id() {
		return Org_Abilities_Id;
	}

	public void setOrg_Abilities_Id(Org_Abilities org_Abilities_Id) {
		Org_Abilities_Id = org_Abilities_Id;
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

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	

}
