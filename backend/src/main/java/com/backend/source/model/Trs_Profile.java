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
@Table(name = "TRS_PROFILE")
@Data
@NoArgsConstructor
public class Trs_Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_PROFILE_ID")
	private long Profile_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_PROFILE_ID", foreignKey = @ForeignKey(name = "ORG_PROFILE_ID_FK"))
	private Org_Profile Org_Profile_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "PROFILE_LANG_ID_FK"))
	private Language Lang_Id;

	@Column(name = "NAME")
	private String Name;

	@Column(name = "LOCATION")
	private String Location;

	@Column(name = "ABOUT", length = 65535, columnDefinition = "TEXT")
	@Type(type = "text")
	private String About;

}
