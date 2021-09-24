package com.backend.source.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.backend.source.common.util.JsonInternationalized;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {

	@Getter(AccessLevel.PUBLIC)
	private long Id;

	@JsonInternationalized
	@NotNull
	private String Name;
	
	
	@NotNull
	private Date DateOfBirth;
	
	@JsonInternationalized
	@NotNull
	private String Location;

	@JsonInternationalized
	@NotNull
	private String About;
}
