package com.backend.source.model;

import java.sql.Date;

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
@Table(name = "LOG_COMMENTER")
public class Log_Commenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOG_COMM_ID")
	private long Commenter_Id;

	@ManyToOne
	@JoinColumn(name = "ORG_BLOG_ID", foreignKey = @ForeignKey(name = "LOG_COM_ORG_BLOG_ID_FK"))
	private Org_Blog Org_Blog_Id;

	@Column(name = "NAME")
	private String Name;


	@Column(name = "EMAIL")
	private String Email;

	@Column(name = "COMMENT", length = 65535, columnDefinition = "TEXT")
	@Type(type = "text")
	private String Comment;

	@Column(name = "COMM_DATE")
	private Date com_date;

	@Column(name = "LOG_COMM_DATE")
	private Date log_date;
	
	// --------------
	// PUBLIC METHODS
	// --------------

	public Log_Commenter() {
	}
	
	public long getCommenter_Id() {
		return Commenter_Id;
	}

	public void setCommenter_Id(long commenter_Id) {
		Commenter_Id = commenter_Id;
	}

	public Org_Blog getOrg_Blog_Id() {
		return Org_Blog_Id;
	}

	public void setOrg_Blog_Id(Org_Blog org_Blog_Id) {
		Org_Blog_Id = org_Blog_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Date getCom_date() {
		return com_date;
	}

	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}

	public Date getLog_date() {
		return log_date;
	}

	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}

}
