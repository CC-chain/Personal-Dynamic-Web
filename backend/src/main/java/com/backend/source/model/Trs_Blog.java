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

@Entity
@Table(name = "TRS_BLOG")
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
	
	//--------------
	// PUBLIC METHODS
	//--------------

	public Trs_Blog() {
	}

	public long getBlog_Id() {
		return Blog_Id;
	}

	public void setBlog_Id(long blog_Id) {
		Blog_Id = blog_Id;
	}

	public Org_Blog getOrg_Blog_Id() {
		return Org_Blog_Id;
	}

	public void setOrg_Blog_Id(Org_Blog org_Blog_Id) {
		Org_Blog_Id = org_Blog_Id;
	}

	public Language getLang_Id() {
		return Lang_Id;
	}

	public void setLang_Id(Language lang_Id) {
		Lang_Id = lang_Id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBlogContent() {
		return BlogContent;
	}

	public void setBlogContent(String blogContent) {
		BlogContent = blogContent;
	}
	
	
}
