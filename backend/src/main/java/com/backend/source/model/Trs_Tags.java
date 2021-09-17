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
@Table(name = "TRS_TAGS")
@Data
@NoArgsConstructor
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

}
