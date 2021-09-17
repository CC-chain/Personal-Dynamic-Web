package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORG_ABILITIES")
@Data
@NoArgsConstructor
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

	

}
