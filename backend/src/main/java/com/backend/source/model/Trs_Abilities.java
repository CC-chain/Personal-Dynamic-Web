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

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TRS_ABILITIES")
@Data
@NoArgsConstructor
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
}
