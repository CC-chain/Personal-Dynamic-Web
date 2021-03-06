package com.backend.source.dto;

import org.springframework.beans.BeanUtils;

import com.backend.source.model.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
	
	private String User_Name;

	private String Password;

	public AdminDto(Admin admin) {
		BeanUtils.copyProperties(admin, this);
	}
}
