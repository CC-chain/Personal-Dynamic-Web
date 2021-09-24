package com.backend.source.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.backend.source.common.util.JsonInternationalized;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperiencesDto {

	@Getter(AccessLevel.PUBLIC)
	private long Id;
	
	@JsonInternationalized
	@NotNull
	private String Name;
	
	
	@NotNull
	private Date Date_First;
	
	
	@NotNull
	private Date Date_Last;
	
	@JsonInternationalized
	@NotNull
	private String Info;
	
	@JsonInternationalized
	@NotNull
	private String Location;
	
	@JsonInternationalized
	@NotNull
	private String Type;
	
	@NotNull
	private String WebSite;
}
