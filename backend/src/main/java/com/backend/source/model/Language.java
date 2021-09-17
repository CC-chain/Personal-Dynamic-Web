package com.backend.source.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LANGUAGE")
@Data
@NoArgsConstructor
public class Language {

	@Id
	@Column(name = "LANG_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "NAME")
	private String Name;

}
