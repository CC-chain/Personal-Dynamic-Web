package com.backend.source.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name = "TRS_BLOG_ID")
	private long Id;

	@ManyToOne
	@JoinColumn(name = "ORG_BLOG_ID", foreignKey = @ForeignKey(name = "ORG_BLOG_ID_FK"))
	private Org_Blog Org_Blog_Id;

	@ManyToOne
	@JoinColumn(name = "LANG_ID", foreignKey = @ForeignKey(name = "BLOG_LANG_ID_FK"))
	private Language Lang_Id;
	
	@ManyToMany
	@JoinTable(
				name = "TRS_BLOG_TAGS",
				joinColumns = {@JoinColumn(name="TRS_BLOG_ID", referencedColumnName = "TRS_BLOG_ID")},
				inverseJoinColumns = {@JoinColumn(name="TRS_TAGS_ID",referencedColumnName = "TRS_TAGS_ID")}
			)
	private Collection<Trs_Tags> Trs_Tags;
	
	@Column(name = "TITLE")
	private String Title;

	@Column(name = "BLOG_CONTENT", columnDefinition = "TEXT")
	@Type(type = "text")
	private String BlogContent;

}
