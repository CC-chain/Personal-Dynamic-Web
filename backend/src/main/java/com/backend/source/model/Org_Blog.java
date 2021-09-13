package com.backend.source.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "ORG_BLOG")
public class Org_Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_BLOG_ID")
	private long Blog_Id;
	
	@Column(name = "TITLE")
	private String Title;
	
	@Column(name="BLOG_CONTENT" , columnDefinition="TEXT")
	@Type(type="text")
	private String BlogContent;
	
	@Column(name = "DATE")
	private Date Date;

	//--------------
	// PUBLIC METHODS
	//--------------
	
	public Org_Blog() {
	}
	
	public long getBlog_Id() {
		return Blog_Id;
	}

	public void setBlog_Id(long blog_Id) {
		Blog_Id = blog_Id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getText() {
		return BlogContent;
	}

	public void setText(String blogcontent) {
		BlogContent = blogcontent;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	
}
