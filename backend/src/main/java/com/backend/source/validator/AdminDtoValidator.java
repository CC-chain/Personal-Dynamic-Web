package com.backend.source.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.source.common.validator.BaseValidator;
import com.backend.source.common.validator.CommonValidatorUtils;
import com.backend.source.dto.AdminDto;
import com.backend.source.model.Admin;
import com.backend.source.repository.AdminRepository;

public class AdminDtoValidator implements BaseValidator<AdminDto> {
		
	private final AdminRepository adminRepository;
	private final CommonValidatorUtils<AdminDto, Admin> commonValidatorUtils;
	
	@Autowired
	public AdminDtoValidator(
				AdminRepository adminRepository,
				CommonValidatorUtils commonValidatorUtils) {
		this.adminRepository = adminRepository;
		this.commonValidatorUtils = commonValidatorUtils;
	}

	@Override
	public void validate(AdminDto obj) {
		validateUniqueCode(obj);
	}
	
	public void validateUniqueCode(AdminDto adminDto) {
		
		Admin admin = this.adminRepository
						  .findByUserName(adminDto.getUser_Name())
						  .orElse(null);
		
		// Found admin with given user_name
		if(admin != null) {
			commonValidatorUtils.validateUniqueField("User_Name", adminDto, admin);
		}
	}
}
