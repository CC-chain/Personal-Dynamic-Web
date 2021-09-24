package com.backend.source.dto;

import lombok.Setter;

import javax.validation.constraints.NotNull;

import com.backend.source.common.util.JsonInternationalized;

import lombok.AccessLevel;
import lombok.Getter;

@Getter
@Setter
public class AbilitiesDto {
	
	@Getter(AccessLevel.PUBLIC)
	private Long Id;
	
	@JsonInternationalized
	@NotNull
	private String Name;
	
	@JsonInternationalized
	@NotNull
	private int Rate;
	
	@JsonInternationalized
	@NotNull
	private String Type;
}
