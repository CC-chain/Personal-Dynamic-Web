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
@Table(name = "TRS_BLOG")
@Data
@NoArgsConstructor
public class Trs_Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRS_Blog_ID")
	private long Blog_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_BLOG_ID", foreignKey = @ForeignKey(name = "ORG_BLOG_ID_FK"))
	private Org_Blog Org_Blog_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "BLOG_LANG_ID_FK"))
	private Language Lang_Id;
	
	@Column(name = "TITLE")
	private String Title;

	@Column(name = "BLOG_CONTENT", columnDefinition = "TEXT")
	@Type(type = "text")
	private String BlogContent;

}
