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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOG_COMMENTER")
@Data
@NoArgsConstructor
public class Log_Commenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOG_COMM_ID")
	private long Id;

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
	

}
