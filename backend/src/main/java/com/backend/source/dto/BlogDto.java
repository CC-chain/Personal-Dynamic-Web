package com.backend.source.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.backend.source.common.util.JsonInternationalized;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogDto {
	
		@Getter(AccessLevel.PUBLIC)
		private long Id;
		
		@JsonInternationalized
		@NotNull
		private String Title;
		
		@JsonInternationalized
		@NotNull
		private String BlogContent;
		
		@NotNull
		private Date Date;
}
