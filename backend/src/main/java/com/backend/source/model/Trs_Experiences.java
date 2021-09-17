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
@Table(name = "TRS_EXPERIENCES")
@Data
@NoArgsConstructor
public class Trs_Experiences {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_EXPERIENCES_ID")
	private long Id;

	@ManyToOne
	@JoinColumn(name = "ORG_EXPERIENCES_ID", foreignKey = @ForeignKey(name = "ORG_EXPERIENCES_ID_FK"))
	private Org_Experiences Org_Experiences_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "EXPERIENCES_LANG_ID_FK"))
	private Language Lang_Id;

	@Column(name = "NAME")
	private String Name;

	@Column(name = "INFO")
	private String Info;

	@Column(name = "LOCATION")
	private String Location;

	@Column(name = "TYPE")
	private String Type;

}
