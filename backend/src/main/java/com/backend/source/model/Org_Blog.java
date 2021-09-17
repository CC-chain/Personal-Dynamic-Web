package com.backend.source.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORG_BLOG")
@Data
@NoArgsConstructor
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


}
