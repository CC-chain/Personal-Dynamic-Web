package com.backend.source.security.service;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.source.common.exception.ApiException;
import com.backend.source.model.Admin;
import com.backend.source.repository.AdminRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByUser_Name(username)
				.orElseThrow(() ->
								new UsernameNotFoundException("Admin user not found with Username : " + 
										username));
		return CustomUserDetails.create(admin);
	}
	
	@Transactional
	public UserDetails loadUserById(Long id) {
		Admin admin = adminRepository.findById(id).orElseThrow(
				() ->  new ApiException("Admin not found ", HttpStatus.NOT_FOUND));
		return CustomUserDetails.create(admin);
	}

}
