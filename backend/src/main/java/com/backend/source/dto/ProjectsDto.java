package com.backend.source.dto;

import javax.validation.constraints.NotNull;

import com.backend.source.common.util.JsonInternationalized;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectsDto {
	@Getter(AccessLevel.PUBLIC)
	private long Id;
	
	
	@JsonInternationalized
	@NotNull
	private String Name;
	
	
	@JsonInternationalized
	@NotNull
	private String Info;
	
	@NotNull
	private String Url;
	
	@JsonInternationalized
	@NotNull
	private String About;
}
